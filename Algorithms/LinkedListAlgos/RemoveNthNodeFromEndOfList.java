package Algorithms.LinkedListAlgos;

/**
 * Given the head of a linked list and an integer n, remove the nth node from the end of the list and return its head.
 * i.e remove node from right side and did not know the size of the LinkedList
 *
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 11 Nov 2024
 */
public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        int n = 2;

        System.out.println(removeNthFromEnd(head, n).val);

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(removeNthFromEndMyApproach(head, n).val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i=0; i<n; i++){ // skip uto n
            fast = fast.next;
        }

        if(fast == null) return head.next;

        while(fast.next != null){ // i.e (length - n) node for slow pointer
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEndMyApproach(ListNode head, int n) {
        if (head.next == null && n==1) return null;
        ListNode sp=head, fp=head; // slow pointer and fast pointer
        int spIndex = 0;
        int len = 0;
        while(fp != null) { // we can't use fp and sp in the same while loop cause we might remove 0th index or index which was already crossed by sp
            if (fp.next != null){
                fp = fp.next.next;
                len+=2;
            } else {
                len++;
                fp = fp.next;
            }
        }
        System.out.println("len: " + len);


        if (len == n) { // 0th index
            return head.next;
        }

        while(sp != null) {
            System.out.println("spIndex: " + spIndex);
            System.out.println("logic: " + (len - spIndex -1));

            if(len - spIndex -1 == n){
                remove(sp);
                break;
            }
            sp = sp.next;
            spIndex++;
        }
        return head;
    }

    private static void remove(ListNode node) {
        if(node.next != null)
            node.next = node.next.next;
    }
}
