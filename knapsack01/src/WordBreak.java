import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */

public class WordBreak {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j<=i; j++){
                if(t[j] && dict.contains(s.substring(j, i))){
                    t[i] = true;
                    break;
                }
            }
        }
        return t[s.length()];
    }


    public static void main(String[] args) {
        WordBreak wordBreakObj = new WordBreak();
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreakObj.wordBreak("", wordDict));
        System.out.println(wordBreakObj.wordBreak("applepen", Collections.emptyList()));
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreakObj.wordBreak("applepenapple", wordDict));
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreakObj.wordBreak("catsandog", wordDict));
        wordDict = Arrays.asList("dog","s","gs");
        System.out.println(wordBreakObj.wordBreak("dogs", wordDict));
    }
}
