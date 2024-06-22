package BasicPrograms;

public class Palindrome { // means reserve of this number is same as original number

    public static void main(String[] args) {
        int n = 3443;
        System.out.println(isPalindrome(n)? "yes" : "no");
    }

    static boolean isPalindrome(int n) {
        return n == Integer.parseInt(new StringBuilder(String.valueOf(n)).reverse().toString());
    }
    
}
