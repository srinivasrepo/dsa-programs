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

        System.out.println();
        mergedList = mergeKListsUsingBinaryTree(new ListNode[]{list1, list2, list3});
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

    /**
     * Convert this to binary tree approach---> brute force
     *
     *        l1    l2     l3      l4     l5
     *        |_____|       |       |      |
     *           |__________|       |      |
     *                 |____________|      |
     *                        |____________|
     *                               |
     *                              res
     *
     * Convert this to binary tree best approach---> improved
     *
     *         l1    l2     l3      l4     l5
     *          |_____|      |_______|      |
     *             |_____________|          |
     *                    |_________________|
     *                              |
     *                             res
     */
    public static ListNode mergeKListsUsingBinaryTree(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        while (lists.length > 1) {
            List<ListNode> res = new ArrayList<>();

            for (int i=0; i<lists.length; i+=2) { // do two and skip to third node
                ListNode l1 = lists[i];
                ListNode l2 = (i+1) < lists.length? lists[i+1]: null;
                res.add(mergeTwoListNodes(l1, l2));
            }
            lists = res.toArray(ListNode[]::new);
        }

        return lists[0];
    }

    private static ListNode mergeTwoListNodes(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(), trav = head;
        while(l1 != null && l2 !=null) {
            if(l1.val < l2.val) {
                trav.next = l1;
                l1 = l1.next;
                trav = trav.next;
            } else {
                trav.next = l2;
                l2 = l2.next;
                trav = trav.next;
            }
        }
        trav.next = (l1 == null)? l2: l1;

        return head.next;
    }

    public static ListNode mergeKListsUsingBinaryTree2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        while (lists.length > 1) {
            ListNode[] mergedLists = new ListNode[lists.length / 2]; // we already know how many ListNodes we have in "Convert this to binary tree best approach---> improved"
            for (int i = 0; i < lists.length; i += 2) {
                mergedLists[i / 2] = mergeTwoLists2(lists[i], lists[i + 1]);
            }
            lists = mergedLists;
        }

        if (lists.length == 1) return lists[0];

        return null;
    }

    private static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }

    public ListNode mergeKListsUsingPriorityQueue(ListNode[] lists) {
        PriorityQueue<Integer> max = new PriorityQueue<>();
        for(ListNode node : lists){
            while(node!=null){
                max.offer(node.val);
                node = node.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode trav = dummy;
        while(!max.isEmpty()){
            trav.next = new ListNode(max.poll());
            trav = trav.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKListsUsingPriorityQueue2(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode dummy = new ListNode(-1), trav = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            trav.next = node;
            trav = trav.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }



    public ListNode mergeKListsUsingTable(ListNode[] lists) {
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

    public ListNode mergeKListsUsingArrayDeque(ListNode[] lists) {
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


}
