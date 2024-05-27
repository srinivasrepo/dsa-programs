package LeetCode;
import java.util.Arrays;

public class RomanToInteger1 {

    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        //IV
        //IX
        //XL
        //XC
        //CD
        //CM
        // M D C L X V I
        int sum = 0;
        for(int i=0; i<s.length(); i++){
            char charAtIndex = s.charAt(i);
            int charValue = getRomanValue(charAtIndex);
            if(Arrays.asList('I', 'X', 'C').contains(charAtIndex) && i<s.length()-1){
                if(shouldSkipNextChar(charAtIndex, s.charAt(i+1))){
                    charValue = getRomanValue(s.charAt(i+1)) - charValue;
                    i++;
                }
            }
            sum += charValue; 
        }
        return sum;
    }

    public static boolean shouldSkipNextChar(char c, char nextChar ){
        if(c == 'I' && Arrays.asList('V','X').contains(nextChar)
        || c == 'X' && Arrays.asList('L','C').contains(nextChar)
        || c == 'C' && Arrays.asList('D','M').contains(nextChar)
        )
            return true;

        return false;
    }

    public static int getRomanValue(char c){
        int value;
        switch(c){
            case 'I': value = 1;
                break;
            case 'V': value = 5;
                break;
            case 'X': value = 10;
                break;
            case 'L': value = 50;
                break;
            case 'C': value = 100;
                break;
            case 'D': value = 500;
                break;
            case 'M': value = 1000;
                break;
            default: value = 0;
        }
        return value;
    }
    
}
