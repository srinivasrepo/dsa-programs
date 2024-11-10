package Algorithms.LinkedListAlgos;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * l1 and l2 are already in reverse order just like we need to add two numbers and carry forward the digit if necessary
 *
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 11 Nov 2024
 */
public class AddTwoNumbers {
    private static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        // ListNode l1 = new ListNode(9);
        // ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9)));

        ListNode l3 = addTwoNumbersMyApproach(l1, l2);

        for(ListNode trav=l3; trav!=null; trav=trav.next){
            System.out.print(trav.val + " ");
        }
    }


    /**
     * @see #addTwoNumbersOldWay(ListNode, ListNode)
    */
    public static ListNode addTwoNumbersMyApproach(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode trav = l3;
        int carryForward = 0;

        while(l1!=null || l2!=null) {

            int n1 = 0;
            int n2 = 0;

            if(l1 != null) {
                System.out.println("l1: " + l1.val);
                n1 = l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                System.out.println("l2: "+l2.val);
                n2 = l2.val;
                l2 = l2.next;
            }

            int n3 = n1+n2+carryForward;

            System.out.println("carryForward: " + carryForward +", n3: " + n3);

            if (n3 > 9) {
                carryForward = n3/10;
                n3 = n3 % 10;
            } else {
                carryForward = 0;
            }

            trav.val = n3;
            trav.next = new ListNode();

            if (l1 == null && l2 == null){
                if(carryForward !=0) {
                    trav.next.val = carryForward;
                    trav.next.next = null;
                } else
                    trav.next = null;
            } else {
                trav = trav.next;
            }
        }

        return l3;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while(l1!=null || l2!=null || carry==1){
            int sum = 0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            sum+=carry;
            carry = sum/10;
            ListNode node = new ListNode(sum%10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode();
		ListNode tail = l3;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int digit1 = l1 != null ? l1.val : 0;
			int digit2 = l2 != null ? l2.val : 0;
			int sum = digit1 + digit2 + carry;
			int value = sum % 10;
			carry = sum / 10;

			ListNode newNode = new ListNode(value);
			tail.next = newNode;
			tail = newNode;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		return l3.next;
    }








    /**
     * Working but failing with java.lang or java.lang.NumberFormatException when
     * l1=[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1] and l2=[5,6,4]
     * i.e when total sequence is greater than Integer.MAX_VALUE and Long.MAX_VALUE
     * So, use strings and solve it like an elementary school addition i.e carry forward the digit to left side
     */
    public static ListNode addTwoNumbersOldWay(ListNode l1, ListNode l2) {
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;
        ListNode l3 = new ListNode();

        String temp = "";
        for(ListNode trav=l1; trav!=null; trav=trav.next){
            temp = trav.val + temp; // reverse
        }
        n1 = Integer.parseInt(temp);
        System.out.println(n1);

        temp = "";
        for(ListNode trav=l2; trav!=null; trav=trav.next){
            temp = trav.val + temp; // reverse
        }
        n2 = Integer.parseInt(temp);
        System.out.println(n2);

        n3 = n1 + n2;

        temp = "" + n3;
        temp = new StringBuilder(temp).reverse().toString();
        System.out.println(temp);
        temp = temp.replaceAll("0", "");

        String[] l3Arr = temp.split("");
        ListNode trav=l3;
        for (int i=0; i<l3Arr.length; i++, trav=trav.next){
            trav.val =Integer.parseInt(l3Arr[i]);
            if(i<l3Arr.length-1) trav.next = new ListNode();
        }

        return l3;
    }
}
