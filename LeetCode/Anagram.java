package LeetCode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("codee", "ecoe","eecod");
        HashMap<Character, Integer> map = new HashMap<>(); 
        // or Map<String, Long> charMap = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(char c: lst.get(0).toCharArray()){
            map.put(c, map.get(c) != null?map.get(c)+1:1); 
            // or map.merge('A', 1, Integer::sum); 
            // or map.put('A', map.getOrDefault('A', 0) + 1 );
        }
        System.out.println(map);

        lst.forEach(str->{
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for(char c: str.toCharArray()){
                tempMap.put(c, tempMap.get(c) != null?tempMap.get(c)+1:1);
            }
            if(!map.equals(tempMap)){
                System.out.println("NOT EQUAL");
                System.exit(0);
            }
        });
        System.out.println("ALL THOSE STRS ARE ANAGRAMS");
    } 

}