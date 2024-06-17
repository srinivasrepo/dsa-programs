package Programs;

import java.util.ArrayList;
import java.util.List;

public class AllDivisors {
    public static void main(String[] args) {
        int n = 36;
        System.out.println("sorted divisors brute force " + getDivisorsBruteForce(n));
        System.out.println("sorted divisors with half Loop better approach " + getDivisorsWithHalfLoopBetterApproach(n));
    }

    /* 
    or loop untill i <= (int) Math.sqrt(n); or i <= n/2 with 
    Add the counterpart divisor if it's different from i
    => if (i != n / i) divisors.add(n / i);

    cause 
    the divisors of 36 number are [1, 2, 3, 4, 6, 9, 12, 18, 36]
    1*36
    2*18
    3*12
    4*9
    6*6
    9*4
    12*3
    18*2
    36*1

    this is repeating after 6*6 in reverse order
 */

    static List<Integer> getDivisorsBruteForce(int n) {
        List<Integer> divs = new ArrayList<>(); // or get size[1] from main method as reference variable get the divs size after the while loop and here create and return divisors array int[n] and start appending from 0th index ike divisors[count++] = i; and size[0] = count; return divisors;
        for (int i = 1; i <= n; i++) {
            if (n%i == 0) {
                divs.add(i);
            }
        }
        return divs;

    }
    static List<Integer> getDivisorsWithHalfLoopBetterApproach(int n) {
        List<Integer> divs = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n%i == 0) {
                divs.add(i); //unsort insertion [1, 36, 2, 18, 3, 12, 4, 9, 6] // or use sort insertion [1, 2, 3, 4, 6, 9, 12, 18, 36] with below logic
                // if (divs.size()>1 && i < divs.get(divs.size()/2)) divs.add(divs.size()/2, i); else divs.add(i);

                int iMutiplier = n/i;
                if (i != iMutiplier) {
                    divs.add(n/i); //unsort insertion [1, 36, 2, 18, 3, 12, 4, 9, 6] // or use sort insertion [1, 2, 3, 4, 6, 9, 12, 18, 36] with below logic
                    // if (divs.size()>1 && iMutiplier < divs.get(divs.size()/2 +1)) divs.add(divs.size()/2 +1, iMutiplier); else divs.add(iMutiplier);
                }
            }
        }
        return divs;

    }
}
