import java.util.HashMap;
import java.util.Map;

public class ScrambledStringMemoized {
    static Map<String, Boolean> t;

    public static void main(String[] args) {
        String a = "great";
        String b = "regat";
        t = new HashMap<>();
        System.out.println(isScrambled(a, b));
    }

    private static boolean isScrambled(String a, String b) {
        String key = a + " " + b;
        Boolean isScrambled = t.getOrDefault(key, null);

        if (isScrambled != null) {
            return isScrambled;
        }

        if (a.length() != b.length()) {
            return false;
        }

        if (a.length() == 1) {
            return false;
        }

        if (a.equals(b)) {
            return true;
        }

        for (int i = 0; i < a.length() - 1; i++) {
            boolean isScrambledWithSwap = isScrambled(a.substring(0, i), b.substring(i + 1)) && isScrambled(a.substring(i + 1), b.substring(0, i));
            boolean isScrambledWithoutSwap = isScrambled(a.substring(0, i), b.substring(0, i)) && isScrambled(a.substring(i + 1), b.substring(i + 1));
            if(isScrambledWithSwap || isScrambledWithoutSwap){
                return true;
            }
        }

        return false;
    }
}
