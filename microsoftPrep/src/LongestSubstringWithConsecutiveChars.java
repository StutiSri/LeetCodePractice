import java.util.LinkedList;

class LongestSubstringWithConsecutiveChars {

    int lswcc(String str) {
        int maxLength = Integer.MIN_VALUE;
        str = str.toLowerCase();
        LinkedList<Character> subString = new LinkedList<>();
        int j = 0;
        int length = str.length();
        while (j < length) {
            char newChar = str.charAt(j);
            if (!isCorrect(subString, newChar)) {
                subString = new LinkedList<>();
            }
            subString.addLast(newChar);
            maxLength = Math.max(maxLength, subString.size());
            j++;
        }
        return maxLength;
    }

    private boolean isCorrect(LinkedList<Character> subString, char newChar) {
        if (subString.size() == 0) {
            return true;
        }
        if (subString.getLast() == 'z' && newChar == 'a') {
            return true;
        }
        return (subString.getLast() + 1) == newChar;
    }
}
