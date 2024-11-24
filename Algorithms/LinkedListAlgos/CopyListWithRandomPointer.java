package Algorithms.LinkedListAlgos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 20 Nov 2024
 */
public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.random = head.next;
        head.next.next.random = head.next.next.next;
        head.next.random = head.next.next.next.next;
        head.random = head.next;
        for (Node trav = head; trav != null; trav = trav.next)
            System.out.print(trav.val + " " + (trav.random == null? null: trav.random.val) + ", ");
        System.out.println("\ncopyRandomListMyApproach -----------");
        for (Node trav = copyRandomListMyApproach(head); trav != null; trav = trav.next)
            System.out.print(trav.val + " " + (trav.random == null? null: trav.random.val) + ", ");
    }

    public static Node copyRandomListMyApproach(Node head) {
        Node dummy = new Node(-1);
        Node prev = dummy;

        List<Integer> lst = new ArrayList<>();
        Map<Integer, Node> copyIndexNodeMap = new HashMap<>();
        Map<Node, Integer> ogNodeIndexMap = new HashMap<>();
        int i=0;

        for (Node trav = head; trav != null; trav = trav.next,i++)
            ogNodeIndexMap.put(trav, i);

        i=0;
        for (Node trav = head; trav != null; trav = trav.next,i++) {
            prev.next = new Node(trav.val);
            prev.next.random = trav.random == null? null: new Node(-1);
            lst.add(trav.random == null? null: ogNodeIndexMap.get(trav.random));

            copyIndexNodeMap.put(i, prev.next);
            prev = prev.next;
        }

        i=0;
        for (Node trav = dummy.next; trav != null; trav = trav.next,i++) {
            if (trav.random != null)
                trav.random=copyIndexNodeMap.get(lst.get(i));
        }
        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null,null);

        Node curr = head;
        while(curr != null){
            // Step1 - start - for curr
            if(!oldToCopy.containsKey(curr)){
                oldToCopy.put(curr, new Node(0));
            }
            //oldToCopy.get(curr).val = curr.val;
            Node copy = oldToCopy.get(curr);
            copy.val = curr.val;
            // Step1 - end

            // Step2 - start - for curr.next
            if(!oldToCopy.containsKey(curr.next)){
                oldToCopy.put(curr.next, new Node(0));
            }
            //oldToCopy.get(curr).next = oldToCopy.get(curr.next);
            copy.next = oldToCopy.get(curr.next);
            // Step2 - end

            // Step3 - start - for curr.random
            if(!oldToCopy.containsKey(curr.random)){
                oldToCopy.put(curr.random, new Node(0));
            }
            //oldToCopy.get(curr).random = oldToCopy.get(curr.random);
            copy.random = oldToCopy.get(curr.random);
            // Step3 - end

            curr = curr.next;
        }

        return oldToCopy.get(head);
    }

    /**
     * Working -- only for unique values i.e failing if we have duplicate values in node.val
     */
    public Node copyRandomListMyOldApproach(Node head) {
        List<Integer> lst = new ArrayList<>();
        Map<Integer, Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node prev = dummy;

        for (Node trav = head; trav != null; trav = trav.next) {
            prev.next = new Node(trav.val);
            prev.next.random = trav.random == null? null: new Node(-1);
            lst.add(trav.random == null? null: trav.random.val);

            map.put(prev.next.val, prev.next);
            prev = prev.next;
        }
            System.out.println(map);
            System.out.println(lst);

        int i=0;
        for (Node trav = dummy.next; trav != null; trav = trav.next,i++) {
            if (trav.random != null) {
                trav.random=map.get(lst.get(i));
            }
        }
        return dummy.next;
    }
}