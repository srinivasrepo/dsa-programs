package Algorithms.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 *  You have the following three operations permitted on a word:
 *
 *  Insert a character
 *  Delete a character
 *  Replace a character
 *
 * </pre>
 *
 *
 *
 *
 *
 * @author Srinivas Vadige
 * @since 16 Oct 2024
 */
public class EditDistance {

    public static void main(String[] args) {

        String word1 = "plasma";
        String word2 = "altruism";

        // String word1 = "intention";
        // String word2 = "execution";
        System.out.println(minDistance(word1, word2));
        System.out.println(minDistanceMyApproach(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }


    /**
     * Failed at word1="plasma" and word2="altruism" because we removed 'm' char and added it later
     *

        My thoughts:
            1st step HashMap both words
        and remove the unwanted char by iterating one char from beggining at a time

        how can we find a matching sub-pattern?? or compare at each operation?

        we have to reduce or increase the word1 len up-to word2 length

        definately bottom-up tabulation or 2 pointer

        n^2 allowed

        delete and insert changes the word1 length

        no need to manipulate word1 in real-time
     */
    public static int minDistanceMyApproach(String word1, String word2) {

        if(word1.isEmpty() && word2.isEmpty()) return 0;

        int count = 0;

        if(word1.length()==1 && word1.length()==word2.length()){
            return word1.equals(word2)?0:1;
        }

        if(word1.isEmpty()){
            word1 += word2.charAt(0);
            count++;
        }

        for(int i=0, j=0; i<Math.max(word1.length(), word2.length()); i++) {
            System.out.println(word1);
            char c1 = i<word1.length()? word1.charAt(i):'\0';
            char c2 = j<word2.length()? word2.charAt(j):'\0';


            if (c1 == c2) {
                    
                System.out.println(word1 + ", " + word2 +  ", i:" + i 
                + ", c1:" + c1 + ",  j:" + j + ", c2:" + c2
                + ", count:"+count);

                j++;
                continue;
            }


            // maintain length as per i and word2
            String midChar = "";

            if(c2!='\0' && i + 1 < word1.length() && c2!=word1.charAt(i+1)
            || c2!='\0' && i + 1 == word1.length()
            || c1=='\0' && c2!='\0'
            ){
                midChar=c2+"";
            }
            if(c2!='\0' && j + 1 < word2.length() && (c1==word2.charAt(j+1)) ){
                midChar=c2+""+c1;
            }

            word1 = word1.substring(0, i) + midChar + ( i+1<word1.length()? word1.substring(i+1):"" );

            count++;

            System.out.println(word1 + ", " + word2 +  ", i:" + i 
            + ", c1:" + c1 + ",  j:" + j + ", c2:" + c2
            + ", count:"+count);

            if (midChar.isEmpty()) // deleted the char
                i--;
            else j++;

        }
        return count;
    }


    /**
     * Failed at word1="plasma" and word2="altruism" because we removed 'm' char and added it later
     * so, use hashmap with decrease counter and compare with >0
    */

    public static int minDistanceMyApproach2(String word1, String word2) {

        if(word1.isEmpty() && word2.isEmpty()) return 0;

        int count = 0;

        if(word1.length()==1 && word1.length()==word2.length()){
            return word1.equals(word2)?0:1;
        }

        if(word1.isEmpty()){
            word1 += word2.charAt(0);
            count++;
        }

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i< word2.length(); i++){
            map.put(word2.charAt(i), i);
        }


        for(int i=0, j=0; i<Math.max(word1.length(), word2.length()); i++) {
            System.out.println(word1);
            char c1 = i<word1.length()? word1.charAt(i):'\0';
            char c2 = j<word2.length()? word2.charAt(j):'\0';


            if (c1 == c2) {
                System.out.println(word1 + ", " + word2 +  ", i:" + i 
                + ", c1:" + c1 + ",  j:" + j + ", c2:" + c2
                + ", count:"+count);

                j++;


                continue;
            }


            // maintain length as per i and word2
            String midChar = "";

            // replace
            if(c2!='\0' && i + 1 < word1.length() && c2!=word1.charAt(i+1)
            || c2!='\0' && i + 1 == word1.length()
            || c1=='\0' && c2!='\0'
            ){
                midChar=c2+"";
            }
            // insert c1==word2.charAt(j+1)
            if(c2!='\0' && j + 1 < word2.length() && map.getOrDefault(c1, 0) > i

            ){
                midChar=c2+""+c1;
            }

            word1 = word1.substring(0, i) + midChar + ( i+1<word1.length()? word1.substring(i+1):"" );

            count++;

            System.out.println(word1 + ", " + word2 +  ", i:" + i 
            + ", c1:" + c1 + ",  j:" + j + ", c2:" + c2
            + ", count:"+count);

            if (midChar.isEmpty()) // deleted the char
                i--;
            else j++;

        }


        return count;
    }
}
