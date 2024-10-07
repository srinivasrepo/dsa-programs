package Algorithms.DynamicProgramming;

/**
 * 
 * @author Srinvas Vadige 
 * @since 06 Oct 2024
 */
public class LongestPalindromicSubstring {

    static int start = 0; // -- only for longestPalindrome()
    static int end = 0; // or use dp = new int[2] instead or just store the maxLen string
    
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println("longestPalindrome: " + longestPalindrome2Improved(s));
        System.out.println("longestPalindromeBruteForce: " + longestPalindromeBruteForce(s));
    }
    
    // Bottom-Up NoMemory DP in palindrome() method
    public static String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        palindrome(ch, 0); // or use dp = new int[2] array instead of start and end i.e palindrome(ch, 0, dp); --- still it would be the Bottom-Up NoMemory DP
        return s.substring(start, end+1);
    }

    // Bottom-Up NoMemory DP -- as we are just storing the start and end index but not all node values in an dedicated array
    private static void palindrome(char[] ch, int i) { // chr[] or s in 1st param
        int l = i;
        int r = i;
        int n = ch.length;
        if (i >= n - 1) // base case
            return;
        while (r < n-1 && ch[r] == ch[r+1]) { // dup char case --- mandatory otherwise we get errors in scenarios like extendPalindrome(i, i) extendPalindrome(i, i+1) 
            r++;
        }
        i = r; /* ---- skipping dup chars for next recursive call */
        while (l > 0 && r < n-1 && ch[l-1] == ch[r+1]) { // palindrome case as both l & r starts from middle
            l--;
            r++;
        }
        if ((end-start) < (r-l)) { // maxLen case
            start = l;
            end = r;
        }
        palindrome(ch, i+1); // to traverse each index i.e 0 to n-1
    }

    public static String longestPalindrome2(String s) {    
        String res = "";
        
        for(int i=0; i<s.length(); i++){
            res = extendPalindrome(s, i, i, res); // non-dup chars --> not even len odd len case
            res = extendPalindrome(s, i, i+1, res); // dup chars or just skip the dup chars like while (r < n-1 && ch[r] == ch[r+1]) {r++;} ---> check longestPalindrome2Improved() and extendPalindrome2Improved
        }        
        return res;
    }
    
    public static String extendPalindrome(String s, int l, int r, String res){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            if(r-l+1 > res.length())
                res = s.substring(l, r+1);
            l--;
            r++;
        }
        return res;
    }

    public static String longestPalindrome2Improved(String s) {    
        String res = "";        
        for(int i=0; i<s.length(); i++){
            res = extendPalindrome2Improved(s, i, i, res);
        }
        return res;
    }
    
    public static String extendPalindrome2Improved(String s, int l, int r, String res){
        while (r < s.length()-1 && s.charAt(r) == s.charAt(r+1)) {r++;} // dup chars case
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){ // validate palindrome case 
            if(r-l+1 > res.length())
                res = s.substring(l, r+1);
            l--;
            r++;
        }
        return res;
    }


    public static String longestPalindromeBruteForce(String s) {
        String res = "";
        for (int i=0; i< s.length(); i++ ){
            for (int j=i+1; j<=s.length(); j++){
                String temp = s.substring(i,j);
                if(temp.length() > res.length() && temp.equals(new StringBuilder(temp).reverse().toString()) )
                    res = temp;
            }
        }

        return res;
    }

    public static String longestPalindromeBruteForce2(String s) {
        String res = "";
        int maxLength = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i+1;j<=s.length();j++) {
                String substr=s.substring(i,j);
                if(checkPalindrome(substr)==true) {
                    int nl = substr.length();
                    if (nl > maxLength) {
                        maxLength = nl;
                        res = substr; 
                    }
                }
            } 
        }
        return res;
    }
    public static boolean checkPalindrome(String str) {
        int first=0;
        int last=str.length()-1;
        while(first<last) {
            if(str.charAt(first)!=str.charAt(last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

}
