package Algorithms.Hashing;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each character in ransomNote may only be used once in magazine.
 * i.e we cut the letter in the magazine book and paste it in our personal Note
 * @author Srinvas Vadige, srinivas.vadige@gmail.com
 * @since 09 Nov 2024
 */
public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstructMyApproach(ransomNote, magazine));
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstructMyApproach(String ransomNote, String magazine) {
        Map<String, Integer> rMap= Arrays.stream(ransomNote.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(_->1)));
        Map<String, Integer> mMap= Arrays.stream(magazine.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(_->1)));

        for(Map.Entry<String, Integer> re: rMap.entrySet() ) {
            if(mMap.getOrDefault(re.getKey(), 0).intValue() < re.getValue().intValue())
                return false;
        }
        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : ransomNote.toCharArray())
            count[c - 'a']++;

        for (char c : magazine.toCharArray())
            count[c - 'a']--;

        for (int i : count)
            if (i > 0) return false;

        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray())
            count[c - 'a']++;

        for (char c : ransomNote.toCharArray())
            if(count[c-'a']-- == 0) return false; // i.e before decrement

        return true;
    }

    public static boolean canConstruct3(String ransomNote, String magazine) {
        int[] check = new int[26];
         for (char c : ransomNote.toCharArray()) {
             int index = magazine.indexOf(c, check[c % 26]);
             if (index < 0)
                 return false;
             check[c % 26] = index+1;
         }
         return true;
    }

    public boolean canConstructBruteForce(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote. length(); i++) {
            char r= ransomNote. charAt(i);

            int matchingIndex = magazine.indexOf(r);
            if (matchingIndex == -1)
                return false;
            magazine = magazine.substring(0, matchingIndex)
            + magazine. substring(matchingIndex + 1); // skip that char and we can have duplicate chars
        }
        return true;
    }
}
