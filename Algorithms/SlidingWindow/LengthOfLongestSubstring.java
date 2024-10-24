package Algorithms.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Srinivas Vadige, srinivas.vadige@gmail.com
 * @since 26 Sept 2024
*/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "dvdfd";
        System.out.println("lengthOfLongestSubstring: "  + lengthOfLongestSubstring(s));
        System.out.println("lengthOfLongestSubstringNoPointers: "  + lengthOfLongestSubstringNoPointers(s));
    }



    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

    /*
     * No nedd to use two pointer approach like MinimumWindowSubString problem. Because we're focussing only one dup char
    */
    public static int lengthOfLongestSubstringNoPointers(String s) {
        if(s.trim().length() == 1)
            return 1;

        if(s.isEmpty()) return 0;

        String subStr = "";
        int maxL = 0;

        String[] chars = s.split("");

        for(int i=0; i<s.length(); i++){
            int repStrIndex = subStr.indexOf(chars[i]); // as we check the index of subStr not s. It's working fine
            if(repStrIndex > -1){
                subStr = subStr.substring(repStrIndex+1) + chars[i]; // --- or HashSet
            } else subStr += chars[i];

            System.out.println(subStr);
            maxL = Math.max(maxL, subStr.length());
        }

        return Math.max(maxL, subStr.length());

     }







     // won't work for Eg: dvdf -- here max sub string length is 3
    public static int lengthOfLongestSubstringHashMap(String s) {


        Map<String, Integer> map = new HashMap<>();
        String[] chars = s.split("");

        int maxL = 0;
        int tempStart=0;
        for(int i=0; i<s.length(); i++){
            if(map.containsKey(chars[i])){
                maxL = Math.max(maxL, i-tempStart);
                tempStart = i;
                map.clear();
                map.put(chars[i], 1);
            }
            else
                map.put(chars[i], 1);
            System.out.println(maxL);
            System.out.println(map);
        }

        return map.keySet().size();
    }
}
