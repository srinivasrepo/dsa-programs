package LeetCode;
public class PalindromeNumber1 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
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
        System.out.println(x);
        System.out.println(temp);
        System.out.println(y);
        return x == y;
    }
}
