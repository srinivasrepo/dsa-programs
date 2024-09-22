package BasicPrograms;

/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
public class PalindromeOrReverseNumber {

    public static void main(String[] args) {
        int n = 543212345; 
        System.out.println("Given number is: " + n);
        System.out.println("Reverse using DIV /10 AND MODULS %10 APPROACH => " + reverse(n));
        System.out.println("Reverse using STRING REVERSE => " + stringReverse(n)); 
        System.out.println("Reverse using STRING BUILDER REVERSE => " + stringBuilderReverse(n));
        System.out.println("isPalindrome: " + isPalindrome(n));
        System.out.println("isPalindromeStringApproach: " + isPalindromeStringApproach(n));
    }

    // reversing using %10 and /10 concept
    static int reverse(int n) { 

        // reversed number 
        int rev = 0; 
  
        while (n > 0) { 
        int lastDigit = n % 10; // remainder
            rev = (rev * 10) + lastDigit; 
            n = n / 10; // quotient
        } 
  
        return rev; 
    }


    static int stringReverse(int n){
        String oStr = String.valueOf(n);
        String nStr = "";

        for (char i : oStr.toCharArray()) { // or for index loop
            nStr = i+nStr; // it is different from nStr += i
        }

        // // or 
        // while (!oStr.equals("")) {
        //     nStr += oStr.charAt(oStr.length()-1);
        //     oStr = oStr.substring(0, oStr.length()-1);
        // }

        return Integer.parseInt(nStr);
    }

    static int stringBuilderReverse(int n){
        return Integer.parseInt(new StringBuffer(String.valueOf(n)).reverse().toString());
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
