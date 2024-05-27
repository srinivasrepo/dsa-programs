package LeetCode;
import java.util.HashMap;

public class RomanToInteger2 {

    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));

    }


    @SuppressWarnings("unchecked")
    public static int romanToInt(String s) {

        @SuppressWarnings("rawtypes")
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for(int i=0; i<s.length(); i++){
            int charValue = map.get(s.charAt(i));
            int nextCharValue = i<s.length()-1? map.get(s.charAt(i+1)): 0;
            // if (charValue < nextCharValue){
            //     charValue = nextCharValue - charValue;
            //     i++;
            // }
            // result += charValue;
            result = result + (charValue<nextCharValue? -charValue: +charValue);
        }

        return result;
    }
    
}
