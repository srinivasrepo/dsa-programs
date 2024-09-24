package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* @author Srinvas Vadige 
* @since 23 Sept 2014
*/
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

        public static List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<String, Long>, List<String>> mapWithList = new HashMap<>();
        
        for(String str: strs) {
            Map<String, Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // or we can use keyStr = Arrays.sort(chars); to compare the keyStr to the items in the loop

            List<String> items = mapWithList.getOrDefault(map, new ArrayList<String>());
            items.add(str);
            mapWithList.put(map, items);
        }

        return mapWithList.values().stream().collect(Collectors.toList());
        
    }
    
}
