package Algorithms.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1- Optimizing box weight: you have 2 boxes A and B return subset A in increasing order where sum of A' weight > sum of B' weight. if More than one subset A exist, return the one with the maximal weight.
 * Conditions:
 *
 *
 * A & B intersection is null
 * Union is equivalent to original array
 * number of elements in A is minimal
 * sum of A weights > sum of B weights
 * 2- another version of https://leetcode.com/problems/robot-bounded-in-circle/ with some more tweaks
 *
 *
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 23 Nov 2024
 */
public class OptimizingBoxWeights {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2,1,3,4,5,6));
        // List<Integer> arr = new ArrayList<>(Arrays.asList(13, 7, 5, 6, 2));
        List<Integer> temp = new ArrayList<>(arr);
        System.out.println(minimalHeaviestSetA(temp));
        temp = new ArrayList<>(arr);
        System.out.println(minimalHeaviestSetA2(temp));
    }

    public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {

        if(arr.size() == 0 || arr.size() == 1) return arr;

        Collections.sort(arr);

        List<Integer> sums = new ArrayList<>();
        int sum = 0;
        for (int n: arr) {
            sum += n;
            sums.add(sum);
        }

        int i;
        int sumA = 0;
        for (i=arr.size()-1; i>=0; i--) {
            sumA += arr.get(i);
            if(sumA > sums.get(i-1))
                break;
        }

        List<Integer> lst = new ArrayList<>();
        for (int j=i; j<arr.size(); j++) lst.add(arr.get(j)); // or add in above for loop and Collections.reverse(lst);

        return lst;
    }

    // NOT WORKING ---- WRONG APPROACH
    public static List<Integer> minimalHeaviestSetA2(List<Integer> arr) {
        List<Integer> lstA = new ArrayList<>(), lstB = new ArrayList<>();
        Collections.sort(arr, Collections.reverseOrder());
        for (int num: arr) {
            if (lstA.stream().mapToInt(i->i).sum() > lstB.stream().reduce(0, Integer::sum))
                lstB.add(num);
            else
                lstA.add(num);
        }
        Collections.reverse(lstA);
        return lstA;
    }
}
