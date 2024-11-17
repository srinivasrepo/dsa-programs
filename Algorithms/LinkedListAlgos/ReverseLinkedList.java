package Algorithms.LinkedListAlgos;

/**
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 17 Nov 2024
 */
class ReverseLinkedList {
    static class ListNode {int val; ListNode next; ListNode(int val){this.val=val;} ListNode(int val, ListNode next){this.val=val; this.next=next;}}

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println("reverseListUsing3Pointers: ");
        for (ListNode trav = reverseListUsing3Pointers(head); trav != null; trav = trav.next) System.out.print(trav.val + " ");

        System.out.println("\nreverseListUsing2Pointers: ");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        for (ListNode trav = reverseListUsing2Pointers(head); trav != null; trav = trav.next) System.out.print(trav.val + " ");

        System.out.println("\nreverseListUsingRecursion: ");
        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        for (ListNode trav = reverseListUsingRecursion(head, null); trav != null; trav = trav.next) System.out.print(trav.val + " ");
    }

    /**
     *
     *             1 -> 2 -> 3 -> 4 -> 5
     *             5 -> 4 -> 3 -> 2 -> 1
     *
     *     null -> 1 -> 2 -> 3 -> 4 -> 5 -> null         -------- START
     *      ↓      ↓    ↓
     *     prev  curr  next
     *
     *
     *     null <- 1 <- 2 <- 3 <- 4 <- 5 -> null         -------- END
     *                                 ↓      ↓     ↓
     *                                prev   curr  next
     *
     *
     * So, we can return prev as head and return it
     */
    public static ListNode reverseListUsing3Pointers(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // temp hold the next sequence
            curr.next = prev; // from -> to <-
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * same as
     * @see #reverseListUsing3Pointers but without curr and use head as curr instead
     *
     *     null -> 1 -> 2 -> 3 -> 4 -> 5 -> null         -------- START
     *      ↓      ↓    ↓
     *     prev  head  next
     *
     *
     *     null <- 1 <- 2 <- 3 <- 4 <- 5 -> null         -------- END
     *                                 ↓      ↓     ↓
     *                                prev   head  next
    */
    public static ListNode reverseListUsing2Pointers(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next; // temp hold the next sequence
            head.next = prev; // from -> to <-
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * same as
     * @see #reverseListUsing2Pointers()
     */
    public static ListNode reverseListUsingRecursion(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode next = curr.next; // temp hold the next sequence
        curr.next = prev; // from -> to <-
        prev = curr;
        return reverseListUsingRecursion(next, prev);
    }
}