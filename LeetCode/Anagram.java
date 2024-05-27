package LeetCode;
import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        List<String> lst = Arrays.asList("codee", "ecoe","eecod");
        HashMap<Character, Integer> map = new HashMap<>(); 
        for(char c: lst.get(0).toCharArray()){
            map.put(c, map.get(c) != null?map.get(c)+1:1);
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