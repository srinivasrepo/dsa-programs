package BasicPrograms;

public class ReverseNumber {

    public static void main(String[] args) {
        int n = 4526; 
        System.out.println("USING DIV /10 AND MODULS %10 APPROACH => " + reverse(n));
        System.out.println("USING STRING REVERSE => " + stringReverse(n)); 
        System.out.println("USING STRING BUILDER REVERSE => " + stringBuilderReverse(n)); 
    }

    // reversing using %10 and /10 concept
    static int reverse(int n) { 

        // reversed number 
        int rev = 0; 
  
        while (n > 0) { 
        int lastDigit = n % 10; // remainder
            rev = (rev * 10) + lastDigit; 
            n = n / 10; // quotient
        } 
  
        return rev; 
    }


    static int stringReverse(int n){
        String oStr = String.valueOf(n);
        String nStr = "";

        for (char i : oStr.toCharArray()) { // or for index loop
            nStr = i+nStr; // it is different from nStr += i
        }

        // // or 
        // while (!oStr.equals("")) {
        //     nStr += oStr.charAt(oStr.length()-1);
        //     oStr = oStr.substring(0, oStr.length()-1);
        // }

        return Integer.parseInt(nStr);
    }

    static int stringBuilderReverse(int n){
        return Integer.parseInt(new StringBuffer(String.valueOf(n)).reverse().toString());
    }
    
}
