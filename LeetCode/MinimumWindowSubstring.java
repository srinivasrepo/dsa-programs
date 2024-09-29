package LeetCode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Srinivas Vadige
 * @since 28 Sept 2023
*/
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println( "minWindow: " + minWindow(s, t));
        // System.out.println( "minWindowBruteForce: " + minWindowBruteForce(s, t));
    }

  
     
     
    /*
      "TO_FIND" counter is length of "t" and it is constant
      "found" counter is used to store the count of t characters in the current subString or window. 
      So, max value of found counter is TO_FOUND t length i.e always foundCounter <= TO_FIND
      if found < TO_FIND ---> then move right pointer to find the remaining t chars. And check if we found remaining t char then increase found counter and "decrease" charsMap or ascii array int[128] specific char by 1
      main while loop with right++
      charsMap.get('right') >= 0 then found++
      if found == TO_FIND ---> then move left pointer (as we got all t chars & we want min subStr) & check if the current left index char is in t string chars, if it is then decrease found counter and "increase" charsMap or ascii array int[128] specific char by 1 as we need to find that in future
      sub while loop with left++
      charsMap.get('left') > 0 then found--
      i.e iterate main loop untill found == TO_FIND then loop sub while loop and then repeat the process untill 
      Remeber to always decrease the right pointer charsMap, ascii array char count by 1 in the parent while loop
      NOTE
      1. we can use charsMap with char counter or ascii array new int[128] with ascii char counter to store the t chars and visited s chars. Because s and t consist of uppercase and lowercase English letters only
      2. And specific s chars are always negative i.e <= -1. And t specific char counter max value is it's repition in t string and min value of negative as per presense in s.
      3. if the t char in charsMap is > 0 then it means we need find that char in s substring that many times.
      4. while loop instead of for ---> while(rightIndex < s.length) eventhough we didn't loop till leftIndex in the rightIndex < s.length last loop we have the TO_FIND == found while loop to complete the left pointer
    */
      /**
      * @TimeComplexity - O(m+n)
    */
    public static String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        String subStr = "";
        int TO_FIND_TARGET = t.length(), found = 0;
        int left=0, right=0;

        // map for both t and s chars
        Map<Character, Integer> charsMap = t.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e->1)) );        

        while(right<s.length()){ // --- right pointer loop (main expression)

            // DECREASE THE RIGHT VISITED CHAR COUNT IN CHARSMAP -------------
            charsMap.merge(s.charAt(right), -1, Integer::sum);

            // is t char? -- we use >=0 cause we already decreased the count in the above. Note that t char min count here is 0 as 1-1 = 0 
            // min t char is 0 as we have found==TO_FIND_TARGET loop
            if(charsMap.get(s.charAt(right)) >= 0 ){
                found++;
            }


            // --- left pointer loop
            // After all t chars count reduced to 0 or lower in charsMap i.e one of the subStr
            while(found==TO_FIND_TARGET){ 
                // calculate subStr ---> as per window len i.e rightIndex-leftIndex+1
                int currWindowL = right - left + 1;
                if(subStr.length() > currWindowL || subStr.length()==0){
                    subStr = s.substring(left, right+1);
                }
                
                // INCREASE THE LEFT VISITED CHAR COUNT IN CHARSMAP -------------
                // i.e revert the charsMap as per left pointer
                // note that what ever we decreased in right pointer, we're increasing the same in left
                charsMap.merge(s.charAt(left), 1, Integer::sum);
                
                // is t char?
                if(charsMap.get(s.charAt(left)) > 0){
                    found--;
                }
                left++;
            }
            
            right++;
        }        
        return subStr;
    }

    public String minWindowAsciiArr(String s, String t) {
        // create count array for t and char array for s
        char[] sArr = s.toCharArray();
        int[] tCount = new int[128];

        // count the occurrences of each char in t
        for (char ch : t.toCharArray()) {
            tCount[ch]++;
        }

        int required = t.length();
        int left = 0, right = 0, min = Integer.MAX_VALUE, start = 0;

        // until end of the char array of s
        while (right < sArr.length) {
            // check if char at right index is required
            if (tCount[sArr[right]] > 0) {
                required--;
            }
            tCount[sArr[right]]--;
            right++;

            // if all chars are found in current window
            while (required == 0) {
                // update the prev min if this min is minimun
                if (right - left < min) {
                    start = left;
                    min = right - left;
                }

                // slide the left pointer towards right
                if (tCount[sArr[left]] == 0) {
                    required++;

                }
                tCount[sArr[left]]++;
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : new String(sArr, start, min);
    }

    /** ------------- wring approach as it cannot check the a single char count of t in s
     * @TimeComplexity - O(s^2 + t)
     * @Intution - the chars in t strings <= chars in subStr
     * @Approach - Check each and every subString and it's length >= t length
    */
    public static String minWindowUsingSet(String s, String t) {
        if(t.length() > s.length()) return "";
       String subStr = "";        

       for(int i=0; i<s.length(); i++){
           for(int j=i+t.length(); j<s.length()+1; j++){ // non exclusive
               String tempSub = s.substring(i, j);
               boolean isMatched = true;

               Set<String> set = Arrays.stream(t.split("")).collect(Collectors.toSet());

               System.out.println(set);
               
               for (String c:  set){
                   if(!tempSub.contains(c))
                       isMatched = false;
               }

               // check t in tempSub
               if(isMatched){
                   if(subStr.length() > tempSub.length() || subStr.length()==0){
                       subStr = tempSub;
                   }
               }
               System.out.println(tempSub);
           }
       }        
       return subStr;
   }
    



    /**
     * @TimeComplexity - O(n^2)
     * @Intution - the chars in t strings <= chars in subStr. So we can use 2 pointer sliding window technique
     * @Approach - Check each and every subString and it's length >= t length
    */
    public static String minWindowBruteForce(String s, String t) {
        if(t.length() > s.length()) return "";
        String subStr = "";
        
        Map<String, Integer> tMap = Arrays.stream(t.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e->1)) );

        for(int i=0; i<s.length(); i++){
            for(int j=i+t.length(); j<s.length()+1; j++){ // non exclusive
                String tempSub = s.substring(i, j);                              
                Map<String, Integer> subStrMap = Arrays.stream(tempSub.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e->1)) );
                // check t in tempSub
                if(validate(tMap, subStrMap)){
                    if(subStr.length() > tempSub.length() || subStr.length()==0)
                        subStr = tempSub;
                }
                System.out.println(tempSub);
            }
        }        
        return subStr;
    }

    static Boolean validate(Map<String, Integer> tMap, Map<String, Integer> subStrMap){
        for(Map.Entry<String, Integer> te: tMap.entrySet()){
            if(subStrMap.getOrDefault(te.getKey(), 0) < te.getValue())
                return false;
        }
        return true;
    }
}
