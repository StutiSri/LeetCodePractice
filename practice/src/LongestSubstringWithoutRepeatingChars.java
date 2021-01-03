import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {
    Map<String, Integer> t = new HashMap<>();
    public int lengthOfLongestSubstring(String s) {
        Integer lengthOfString = t.get(s);
        if(lengthOfString != null){
            return lengthOfString;
        }
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            t.put(s, 1);
            return 1;
        }
        if (stringWithUniqueChars(s)) {
            t.put(s, length);
            return length;
        }
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < length - 1; i++) {
            String leftSubstring = s.substring(0, i + 1);
            Integer left = t.get(leftSubstring);
            if(left == null){
                left = lengthOfLongestSubstring(leftSubstring);
            }
            String rightSubstring = s.substring(i + 1);
            Integer right = t.get(rightSubstring);
            if(right == null){
                right = lengthOfLongestSubstring(rightSubstring);
            }
            int temp = Math.max(left, right);
            maxLength = Math.max(temp, maxLength);
        }
        t.put(s, maxLength);
        return maxLength;
    }

    private boolean stringWithUniqueChars(String str) {
        Map<Character, Boolean> chars = new HashMap<>();
        for (char character : str.toCharArray()) {
            if (chars.get(character) != null) {
                return false;
            }
            chars.put(character, true);
        }
        return true;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime * 0.001);
        String a = "udsgtcazkdgyijogsuvspkqrfrmgyauufocatczdhidpttxlntgdfwwnnktnmqhrejtxmucveflxzkjmdrr";
        System.out.println(new LongestSubstringWithoutRepeatingChars().lengthOfLongestSubstring(a));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);
    }
}
