package DataStructures;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListExample {
    public static void main(String[] args) {
        System.out.println("LinkedList with List Interface ----------");
        List<Integer> arrList = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(2);
        list.subList(0, 2);
        list.set(0, 5);
        list.get(0);
        list.size();
        list.clear();
        list.contains(1);
        list.containsAll(arrList);
        list.isEmpty();
        list.forEach(System.out::println);
        list.indexOf(1);
        list.lastIndexOf(1);
        list.remove(0);
        list.removeAll(arrList);
        list.retainAll(arrList);
        list.toArray();
        list.toString();
        // useful LinkedList & ArrayList methods
        list.addFirst(5);
        list.addLast(6);
        list.getFirst();
        list.getLast();
        list.removeFirst();
        list.removeLast();
        arrList.addFirst(1);

        // @since JDK 21 methods
        list.reversed(); // in LinkedList
        // note that in List interface added addFirst, addLast, removeFirst, removeLast methods directly and we still have the old methods in LinkedList and ArrayList as well

        // @since JDK 10
        list = arrList = List.copyOf(list); // ImmutableCollections

        // @since JDK 9
        list = arrList = List.of(1,2,3);




        System.out.println("LinkedList with Queue Interface ----------");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.addAll(list);
        queue.remove();
        queue.remove(1);
        queue.removeAll(arrList);
        queue.retainAll(arrList);
        queue.poll(); // remove the first element and returns it i. same as queue.remove()
        queue.offer(4); // add the element at the end i.e same as queue.add(4)
        queue.element(); // returns the first element
        queue.peek();
        queue.size();
        queue.clear();
        queue.contains(1);
        queue.containsAll(arrList);
        queue.isEmpty();
        queue.forEach(System.out::println);
        queue.iterator();
        queue.toArray();
        queue.toString();


        System.out.println("LinkedList with Custom Stack ----------");
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();
        System.out.println("Top element: " + stack.peek());
        System.out.println("Remove two elements from the stack:");
        stack.pop();
        stack.pop();
        stack.display();
        stack.size();
        System.out.println("Top element: " + stack.peek());


        System.out.println("DoubleLinkedList ----------"); // same like Deque
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addFirst(1);
        doubleLinkedList.addLast(2);
        doubleLinkedList.addFirst(3);
        doubleLinkedList.addLast(4);
        doubleLinkedList.addFirst(5);
        doubleLinkedList.addLast(6);
        doubleLinkedList.display();

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);
        deque.addLast(4);
        deque.addFirst(5);
        deque.addLast(6);
        deque.element();
    }

    static class Node { // separate static class or can have private class in LinkedListStack itself
        int value;
        Node next; // next or head
    }

    // we can have it as static class or separate class
    private static class LinkedListStack { // or implements Queue
        private Node head; // the first node
        private int size;

        // nest class to define LinkedList node
        private class Node {
            int value;
            Node next;
        }

        public LinkedListStack() {
            head = null;
            size = 0;
        }

        // Remove value from the beginning of the list for demonstrating behavior of stack
        public int pop() throws LinkedListEmptyException {
            if (head == null) {
                throw new LinkedListEmptyException();
            }
            int value = head.value;
            head = head.next;
            size--;
            return value;
        }

        // Add value to the beginning of the list for demonstrating behavior of stack
        public void push(int value) {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = oldHead;
            size++;
        }

        public int size() {
            return size;
        }

        // Method to check if the stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Method to display the stack
        public void display() {
            if (isEmpty()) {
            System.out.println("Stack is empty");
            } else {
            Node current = head;
            System.out.print("Stack elements: ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
            }
        }

        // Method to get the top element of the stack
        public int peek() {
            if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
            }
            return head.value;
        }
    }

    static class LinkedListEmptyException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public LinkedListEmptyException() {
            super();
        }

        public LinkedListEmptyException(String message) {
            super(message);
        }
    }

    static class DoubleLinkedList {
        Node head;
        Node tail;
        int size;

        public void addFirst(int value) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.next = head;
            head = newNode;
            size++;
            if (tail == null) {
                tail = head;
            }
        }

        public void addLast(int value) {
            Node newNode = new Node();
            newNode.value = value;
            if (tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        }

        public void display() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }

        public int size() {
            return size;
        }

        public void clear() {
            head = null;
            tail = null;
            size = 0;
        }

        public boolean contains(int value) {
            Node current = head;
            while (current != null) {
                if (current.value == value) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        public boolean containsAll(int[] arr) {
            Node current = head;
            while (current != null) {
                for (int i = 0; i < arr.length; i++) {
                    if (current.value == arr[i]) {
                        return true;
                    }
                }
                current = current.next;
            }
            return false;
        }

        public int get(int index) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        }

        public int indexOf(int value) {
            Node current = head;
            int index = 0;
            while (current != null) {
                if (current.value == value) {
                    return index;
                }
                current = current.next;
                index++;
            }
            return -1;
        }

        public int lastIndexOf(int value) {
            Node current = head;
            int index = 0;
            int lastIndex = -1;
            while (current != null) {
                if (current.value == value) {
                    lastIndex = index;
                }
                current = current.next;
                index++;
            }
            return lastIndex;
        }

        public boolean remove(int value) {
            Node current = head;
            Node previous = null;
            while (current != null) {
                if (current.value == value) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

        public boolean removeAll(int[] arr) {
            Node current = head;
            Node previous = null;
            while (current != null) {
                for (int i = 0; i < arr.length; i++) {
                    if (current.value == arr[i]) {
                        if (previous == null) {
                            head = current.next;
                        } else {
                            previous.next = current.next;
                        }
                        size--;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

        public void reverse() {
            Node current = head;
            Node previous = null;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int[] toArray() {
            int[] arr = new int[size];
            Node current = head;
            int index = 0;
            while (current != null) {
                arr[index] = current.value;
                current = current.next;
                index++;
            }
            return arr;
        }

        public void sort() {
            Node current = head;
            while (current != null) {
                Node next = current.next;
                while (next != null) {
                    if (current.value > next.value) {
                        int temp = current.value;
                        current.value = next.value;
                        next.value = temp;
                    }
                    next = next.next;
                }
                current = current.next;
            }
        }

        public void add(int index, int value) {
            if (index == 0) {
                addFirst(value);
            } else if (index == size) {
                addLast(value);
            } else if (index > size) {
                System.out.println("Index out of bounds");
            } else {
                Node newNode = new Node();
                newNode.value = value;
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
                size++;
            }
        }
    }
}
