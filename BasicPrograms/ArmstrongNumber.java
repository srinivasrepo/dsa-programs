package BasicPrograms;
/* 
An Amrstrong number is a number that is equal to the sum of its own digits each 
raised to the power of the number of digits.
 */
public class ArmstrongNumber {
    public static void main(String[] args) {
        int n = 9474;
        System.out.println(isAmstrong(n)? "yes" : "no");
    }
    
    static boolean isAmstrong(int n) {
        int sum = 0;
        int orgNum = n;
        int noOfDigits = (int) Math.log10(n) + 1; // or String.valueOf(num).length();
        while (n>0) {
            int lastDigit = n%10; // remainder
            n = n/10; // quotient
            sum += (int) Math.pow(lastDigit, noOfDigits); // in java ^ is bitwise XOR operator and ** don't work as power like js
        }
        return sum == orgNum;
    }
}
