package BasicPrograms;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 41;
        System.out.println("Brute force => " + (isPrimeBruteForce(n) ? "yes" : "no"));
        System.out.println("Better approach or Half loop with count => " + (isPrimeHalfLoopApproachWithCount(n) ? "yes" : "no"));
        System.out.println("Better approach or Half loop without count => " + (isPrimeHalfLoopApproach(n) ? "yes" : "no"));
    }

    static boolean isPrimeBruteForce(int num) {
        // Corner case as 1 is not prime and 0 & negatives are also not prime
        if (num <= 1)
            return false;
        // Check from 2 to n-1
        for (int i = 2; i < num; i++)
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

        int cnt = 0; // Initialize a counter variable to count the number of factors.

        for (int i = 2; i <= Math.sqrt(n); i++) { // or for (int i = 2; i <= n/2; i++)
            if (n % i == 0) { // If n is divisible by i without any remainder.
                cnt = cnt + 1; // Increment the counter.
                
                if (n / i != i) cnt = cnt + 1; // OPTIONAL : If n is not a perfect square, count its reciprocal factor.
            }
        }
        
        if (cnt > 2) // If the number of factors is exactly 2.
            return true;
        return false;
    }

    static boolean isPrimeHalfLoopApproach(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) { // or for (int i = 2; i <= n/2; i++)
            if(n%i == 0) return true;
        }
        return false;
    }

}
