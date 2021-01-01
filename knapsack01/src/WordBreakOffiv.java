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

public class WordBreakOffiv {
    public boolean wordBreak(String s, List<String> wordDict) {
        return isWordBreakPossible(s,
                new HashSet<>(wordDict),
                0,
                new Boolean[s.length()]);
    }

    private boolean isWordBreakPossible(String stringA, Set<String> wordDict, int start, Boolean[] memo) {
        if(start == stringA.length()){
            return true;
        }
        if(memo[start] != null){
            return memo[start];
        }
        for(int end = start + 1; end <= stringA.length(); end++){
            if(wordDict.contains(stringA.substring(start, end)) && isWordBreakPossible(stringA, wordDict, end, memo)){
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {
        WordBreakOffiv wordBreakObj = new WordBreakOffiv();
        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreakObj.wordBreak("", wordDict));
        System.out.println(wordBreakObj.wordBreak("applepen", Collections.emptyList()));
        wordDict = Arrays.asList("apple", "pen");
        System.out.println(wordBreakObj.wordBreak("applepen", wordDict));
        wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreakObj.wordBreak("catsandog", wordDict));
    }
}
