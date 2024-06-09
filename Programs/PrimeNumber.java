package Programs;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(40)? "yes": "no");
    }

    static boolean isPrime(int num) {
        // Corner case as 1 is not prime and 0 & negatives are also not prime
        if (num <= 1)
            return false;
        // Check from 2 to n-1
        for (int i = 2; i < num; i++) // or  for (int i = 2; i <= n / 2; i++) or for (int i = 2; i <= Math.sqrt(n); i++)
            if (num % i == 0)
                return false;
        return true;
    }
}
