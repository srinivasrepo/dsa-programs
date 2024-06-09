package Programs;

public class ReverseNumber {

    public static void main(String[] args) {
        int n = 4526; 
        System.out.print("Reversed Number is " + reverse(n)); 
    }

    // reversing using %10 and /10 concept
    static int reverse(int n) { 
        // reversed number 
        int rev = 0; 
        // remainder 
        int rem; 
  
        while (n > 0) { 
            rem = n % 10; 
            rev = (rev * 10) + rem; 
            n = n / 10; 
        } 
  
        return rev; 
    } 
    
}
