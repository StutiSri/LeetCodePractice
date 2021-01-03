import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int n = s.length();
        int i = 0;
        int j = 0;
        Set<Character> currentSubString = new HashSet<>();
        while (j < n) {
            char currentChar = s.charAt(j);
            if (currentSubString.contains(currentChar)) {
                while (currentSubString.contains(currentChar)) {
                    currentSubString.remove(s.charAt(i));
                    i++;
                }
            }
            currentSubString.add(currentChar);
            if (currentSubString.size() > maxLength) {
                for (Character character : currentSubString) {
                    System.out.print(character);
                }
                System.out.println();
            }
            maxLength = Math.max(maxLength, currentSubString.size());
            j++;
        }
        return maxLength;
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
