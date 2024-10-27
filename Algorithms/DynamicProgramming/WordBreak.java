package Algorithms.DynamicProgramming;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <pre>
    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
    n^2 allowed
    wordDict is like a set as every word is unique

    loop wordDict and divide the left and right parts of "s" as per word index =
    and again check next  word index divide left and right parts ... so on =
    and finally all "s" parts in wordDict

    looks like binary tree

    top-down memo dp? -- remove the matched word in wordDict i.e n-1 and send to child?

    t-d return? =

    note that word in wordDict can have multiple instances in "s" --> so n-1 the list? or hashmap to check if already validated?

    </pre>

    @author : Srinivas Vadige, srinivas.vadige@gmail.com
    @since : 26 Oct 2024
 */
public class WordBreak {
    public static void main(String[] args) {
        // "ccaccc", ["cc","ac"]
        // "leetcode", ["leet", "code"]
        String s = "ccaccc";
        List<String> wordDict = Arrays.asList("cc","ac");
        System.out.println("wordBreakStartsWithRecursiveBacktracking: " + wordBreakStartsWithRecursiveBacktracking(s, wordDict));
        System.out.println("wordBreakBottomUpTabulation: " + wordBreakBottomUpTabulation(s, wordDict));
        System.out.println("wordBreakBottomUpTabulation2: " + wordBreakBottomUpTabulation2(s, wordDict));
        System.out.println("wordBreakDfs: " + wordBreakDfs(s, wordDict));
        System.out.println("wordBreakTrieApproach: " + wordBreakTrieApproach(s, wordDict));
    }

    /**
     * <pre>
     * traverse only the custom start indices and check if any word in wordDict can be formed from that index
     * works on "future start indices" or "next validation start indices" - i.e up to index-1 substring is already calculated
     * so, after total validation, the future start index of the complete string s="leetcode" is s.length() => "leetcode↓" i.e not s.length()-1
     * Note: In this all possible future start index validations, we might have same start index
     * --> i.e in this kind of dp we do not return already calculated value but we might assign same value "true" to same index in multiple possibilities
     * so, using this we can also calculate count of all possibilities to form the s string with some extra logic
     * </pre>
     * @TimeComplexity O(mn)
     * @SpaceComplexity O(m)
     */
    public static boolean wordBreakBottomUpTabulation(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1]; // +1 for "leetcode↓" and dp can be - int[] or boolean[]
        dp[0] = 1; // initial start index i.e for if (dp[i] == 0) continue; when i = 0
        for (int i = 0; i < s.length(); i++) {
           if (dp[i] == 0) continue; // => skip up to future index & for dp[0] = 1 i.e up to that index or indices we already calculated the subString in the above loop
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) { // in <= s.length() we have == as we want "leetcode↓" not up to last "e" but after after that
                    dp[i + w.length()] = 1; // set all possible future start indices (isSameWord end index)
                }
            }
        }
        return dp[s.length()] == 1; // "leetcode↓" - "next validation start index" of the complete string is true
    }

    public static boolean wordBreakBottomUpTabulation2(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()]; // true for valid start indices
        for (int i = s.length() - 1; i >= 0; i--) {
            if (wordDict.contains(s.substring(i)))
                dp[i] = true;
            else {
                for (int j = i + 1; j < s.length(); j++) { // or word list for loop
                    if (dp[j] && wordDict.contains(s.substring(i, j))) { // dp[j] == true means s.substring(j) is valid
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0]; // "[l]eetcode" i.e total s validation completed from right to left
    }

    /**
     * Top-Down Memo DP but as we start from 0 index we call it as dfs i.e increase depth
     * and if matched then make the start index as "after that word"
     */
    public static boolean wordBreakDfs(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return dfs(s, 0, wordDict, dp);
    }

    private static boolean dfs(String s, int i, List<String> list, Boolean[] dp) {
        if (i >= s.length()) return i == s.length(); // exactly matched "leetcode↓" and IndexOutOfBound base case
        // above condition is same as if(i == s.length()) return true; else if(i > s.length()) return false;
        if (dp[i] != null) return dp[i];

        for (String word : list) {
            if (s.startsWith(word, i) && dfs(s, i + word.length(), list, dp)) // isValid? (then check new start index isValid? by making i == "after that word") and if not valid then (check the next word in the list)
                return true;
        }
        dp[i] = false;
        return false;
    }

    public static boolean wordBreakTrieApproach(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || dp[i - 1]) {
                TrieNode curr = root;
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (!curr.children.containsKey(c)) {
                        // No words exist
                        break;
                    }

                    curr = curr.children.get(c);
                    if (curr.isWord) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }





    // -------------- MY THOUGHTS -------------

    public static boolean wordBreakIndexOfApproach(String s, List<String> wordDict) {
        Map<String, Integer> map = wordDict.stream().collect(
            Collectors.groupingBy(i->i, Collectors.summingInt(e->0)) );
        return rec1(s, map);
    }

    // -- failing for "ccaccc" ["cc","ac"] and "aaaaaaa" ["aaaa","aaa"]
    public static boolean rec1(String s, Map<String, Integer> map ){
        //System.out.println(s);
        int i = -1;
        if(s.isEmpty()) return true;
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            //System.out.println(s + " " + entry.getKey());
            if(s.equals(entry.getValue()) || map.keySet().contains(s)) return true;

            i = s.indexOf(entry.getKey());

            if(i>-1){
                map.put(entry.getKey(), entry.getValue()+1);
                return rec1( i==0? "" : s.substring(0, i), map)
                && rec1( s.substring(i+entry.getKey().length()), map );
            }
        }
        if(i==-1) return false;
        return true;
    }

    // success for "ccaccc" ["cc","ac"] and "aaaaaaa" ["aaaa","aaa"] but
    // --- failing for "catsandogcat" ["cats","dog","sand","and","cat","an"]
    // because it can divide it with "sand", "and"
    // write a logic to check with all start possibilities like cat and cats...
    // so, use startsWith() instead of indexOf??
    public boolean rec2(String s, Map<String, Integer> map ){
        //System.out.println(s);
        int i = -1;
        if(s.isEmpty()) return true;
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            //System.out.println(s + " " + entry.getKey());
            if(s.equals(entry.getKey())){
                map.merge(s, 1, Integer::sum);
                return true;
            }

            i = s.indexOf(entry.getKey());

            if(i>-1){
                if(entry.getValue() > 0) continue;
                map.put(entry.getKey(), entry.getValue()+1);
                return rec2( i==0? "" : s.substring(0, i), map)
                && rec2( s.substring(i+entry.getKey().length()), map );
            }
        }
        if(i==-1) return false;
        return true;
    }

    /**
     * working but TLE
     * check wordBreakIndexOfApproach() for more understanding
     * note that wordBreakIndexOfApproach() only works for unique words with unique chars
    */
    public static boolean wordBreakStartsWithRecursiveBacktracking(String s, List<String> wordDict) {
        boolean[] dp = new boolean[]{false};
        recBt(s, wordDict, dp);
        return dp[0];
    }

    private static void recBt(String s, List<String> list, boolean[] dp) {
        //System.out.println(s);
        if (s.isEmpty()){
            dp[0]=true;
            return;
        }
        else if(dp[0] == true) return;

        for (String w: list) {
            if(dp[0] == true) return;
            if(s.startsWith(w)) {
                recBt(s.substring(w.length()), list, dp);
            }
        }
    }

    /**
     * STILL TLE
     * same as wordBreakStartsWithRecursiveBacktracking() but use dp memo for todo index
     * "catsandogcat", ["cats","dog","sand","and","cat","an"]
     * here check "cats" scenario, "cat" scenario and here we already reached last "ogcat" case
     * as we already checked upto "catsand" i.e "cats, and" or "cat sand"
     */
    public static boolean wordBreakStartsWithTopDownMemoDp(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        rec(s, wordDict, dp, s.length()-1);
        return dp[dp.length-1]; // last index to save if we already reached up to "" in rec()
    }

    private static boolean rec(String s, List<String> list, boolean[] dp, int i) {
        System.out.println(s);
        if (s.isEmpty()){
            dp[dp.length-1]=true;
            return true;
        }
        else if(dp[dp.length-1] == true) return true;
        else if(dp[i] == true) return true;

        for (String w: list) {
            if(dp[dp.length-1] == true) return true;
            if(s.startsWith(w)) {
                dp[i] = rec(s.substring(w.length()), list, dp, dp.length-s.length()-1);
            }
        }

        return false;
    }

}

class TrieNode {
    boolean isWord;
    Map<Character, TrieNode> children;

    TrieNode() {
        this.children = new HashMap<>();
    }
}
