public class ScrambledStringRecursive {
    public static void main(String[] args) {
        String a = "great";
        String b = "regat";
        System.out.println(isScrambled(a, b));
    }

    private static boolean isScrambled(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        if (a.length() == 1) {
            return false;
        }

        if(a.equals(b)){
            return true;
        }

        for (int i = 0; i < a.length() - 1; i++) {
            boolean cond1 = isScrambled(a.substring(0, i), b.substring(i + 1)) && isScrambled(a.substring(i + 1), b.substring(0, i));
            boolean cond2 = isScrambled(a.substring(0, i), b.substring(0, i)) && isScrambled(a.substring(i + 1), b.substring(i + 1));
            if (cond1 || cond2) {
                return true;
            }
        }
        return false;
    }
}
