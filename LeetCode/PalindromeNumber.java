package LeetCode;
/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
public class PalindromeNumber {
    public static void main(String[] args) {
        int n = 12321;
        System.out.println("isPalindrome: " + isPalindrome(n));
        System.out.println("isPalindromeStringApproach: " + isPalindromeStringApproach(n));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int temp = x;
        int y = 0; // reverse of x

        while (temp!=0) {
            y = y * 10 + temp % 10; // 0 + 0 // 0 + 1
            temp = temp / 10; // 1
        }
        return x == y;
    }

    public static boolean isPalindromeStringApproach(int x) {       
        return new StringBuilder(String.valueOf(x)).reverse().toString().equals(String.valueOf(x));
    }
}
