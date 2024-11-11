package Algorithms.LinkedListAlgos;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given the heads of k sorted linked lists list1, list2, ..., list k, return the sorted list
 * containing all the lists in sorted order.
 *
 *
 * @see Algorithms.LinkedListAlgos.MergeTwoSortedLists#mergeTwoListsUsingSort(Algorithms.LinkedListAlgos.MergeTwoSortedLists.ListNode, Algorithms.LinkedListAlgos.MergeTwoSortedLists.ListNode)
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 11 Nov 2024
 */
public class MergeKSortedLists {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        ListNode mergedList = mergeKListsUsingSort(new ListNode[]{list1, list2, list3});

        for(ListNode trav = mergedList; trav != null; trav = trav.next) {
            System.out.print(trav.val + " ");
        }

    }

    public static ListNode mergeKListsUsingSort(ListNode[] lists) {
        List<Integer> lst = new ArrayList<>();
        for(ListNode node: lists) {
            for(ListNode trav=node; trav!=null; trav=trav.next)
                lst.add(trav.val);
        }

        if(lst.size()==0) return null;

        Collections.sort(lst);

        ListNode dummy = new ListNode(-1);
        ListNode trav = dummy;
        for (Integer n: lst){
            trav.next=new ListNode(n);
            trav = trav.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (ListNode list : lists) {
            while (list != null) {
                int val = list.val;
                if (val > max) {
                    max = val;
                }
                if (val < min) {
                    min = val;
                }
                list = list.next;
            }
        }
        // bucket where each bucket corresponds to a specific value.
        /*
         Each position in table acts as a bucket, storing nodes of the same value by
         chaining them together using the next pointers
         */
        ListNode[] table = new ListNode[max - min + 1];
        for (int i = lists.length - 1; i >= 0; i--) {
            ListNode node = lists[i], temp;
            while (node != null) {
                temp = node.next;
                node.next = table[node.val - min];
                table[node.val - min] = node;
                node = temp;
            }
        }
        ListNode result = new ListNode();
        ListNode pointer = result;
        for (ListNode node : table) {
            if (node != null) {
                pointer.next = node;
                pointer = pointer.next;
                while (node.next != null)
                    node = node.next;
                pointer = node;
            }
        }
        return result.next;
    }

        public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> queue = new ArrayDeque<>();

        for (ListNode l : lists) {
            if (l != null) {
                queue.offer(l);
            }
        }

        while (queue.size() >= 1) {
            if (queue.size() == 1) {
                return queue.peek();
            }

            ListNode merged = merge(queue.poll(), queue.poll());
            queue.offer(merged);
        }

        return null;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode merged = new ListNode();
        ListNode temp = merged;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        if (head1 != null) {
            temp.next = head1;
        }
        if (head2 != null) {
            temp.next = head2;
        }

        return merged.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<Integer> max = new PriorityQueue<>();
        for(ListNode node : lists){
            while(node!=null){
                max.offer(node.val);
                node = node.next;
            }
        }
        //System.out.println(max.size());
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(!max.isEmpty()){
            dummy.next = new ListNode(max.poll());
            dummy = dummy.next;
        }
        return res.next;
    }
}
