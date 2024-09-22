package BasicPrograms;

/**
* @author Srinvas Vadige 
* @since 21 Sept 2014
*/
public class PrimeNumber {
    public static void main(String[] args) {
        int n = 36;
        System.out.println("Brute force => isPrime: " + (isPrimeBruteForce(n) ? "yes" : "no"));
        System.out.println("Better approach or Half loop with count => isPrime: " + (isPrimeHalfLoopApproachWithCount(n) ? "yes" : "no"));
        System.out.println("Better approach or Half loop without count => isPrime: " + (isPrimeHalfLoopApproach(n) ? "yes" : "no"));
    }

    static boolean isPrimeBruteForce(int num) {
        // Corner case as 1 is not prime and 0 & negatives are also not prime
        if (num <= 1)
            return false;
        // Check from 2 to n-1
        for (int i = 2; i < num; i++) // or i <= num/2
            if (num % i == 0)
                return false;
        return true;
    }

    /*
     * 
     * or loop untill i <= (int) Math.sqrt(num); or i <= num/2 with
     * Add the counterpart divisor if it's different from i
     * => if (i != num / i) divisors.add(num / i);
     * 
     * cause
     * the divisors of 36 number are [1, 2, 3, 4, 6, 9, 12, 18, 36]
     * 1*36
     * 2*18
     * 3*12
     * 4*9
     * 6*6
     * 9*4
     * 12*3
     * 18*2
     * 36*1
     * 
     * this is repeating after 6*6 in reverse order
     */

    static boolean isPrimeHalfLoopApproachWithCount(int n) {        
        if (n <= 1) return false; // Corner case as 1 is not prime and 0 & negatives are also not prime
        int cnt = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt++;                
                if (n/i != i) cnt++; // Reciprocal factor / counterpart
            }
        }        
        return cnt == 2; // i.e number of factors is exactly 2
    }

    static boolean isPrimeHalfLoopApproach(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++)
            if(n%i == 0) return false;
        return true;
    }

}
