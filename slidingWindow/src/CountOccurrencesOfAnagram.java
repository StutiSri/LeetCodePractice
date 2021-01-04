import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagram {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime * 0.001);
        String a = "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk";
        String b = "kkkkk";
        System.out.println(occurOfAnagrams(a.toLowerCase(), b.toLowerCase()));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);
    }

    private static int occurOfAnagrams(String pat, String txt) {
        Map<Character, Integer> alphabetsAnagram = new HashMap<>();
        int k = txt.length();
        for (char c : txt.toCharArray()) {
            int count = alphabetsAnagram.getOrDefault(c, 0);
            alphabetsAnagram.put(c, ++count);
        }

        int count = 0;
        int distinctChars = alphabetsAnagram.size();
        int i = 0;
        int j = 0;
        while (j < pat.length()) {
            char currentChar = pat.charAt(j);
            int currentCount = alphabetsAnagram.getOrDefault(currentChar, 0);
            if (currentCount == 0) {
                char charAtI = pat.charAt(i);
                if(charAtI != currentChar){
                    alphabetsAnagram.put(charAtI, 1);
                    distinctChars++;
                }
                i++;
            } else if (currentCount == 1) {
                alphabetsAnagram.put(currentChar, 0);
                distinctChars--;
            } else {
                alphabetsAnagram.put(currentChar, currentCount - 1);
            }
            if (j == (i + k - 1)) {
                if (distinctChars == 0) {
                    count++;
                }
                char charAtI = pat.charAt(i);
                Integer countForI = alphabetsAnagram.get(charAtI);
                if(countForI != null){
                    alphabetsAnagram.put(charAtI, countForI + 1);
                    distinctChars++;
                }
                i++;
            }
            j++;
        }

        return count;
    }

}
