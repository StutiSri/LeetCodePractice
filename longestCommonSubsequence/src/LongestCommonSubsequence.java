public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "abcdrfhgt";
        String Y = "adjhfcvft";

        System.out.println(lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    private static int lcs(char[] X, char[] Y, int n, int m) {
        if (n == 0 || m == 0){
            return 0;
        }
        if(X[n-1] == Y[m-1]){
            return 1 + lcs(X, Y, n-1, m-1);
        }
        return Math.max(lcs(X, Y, n-1, m), lcs(X, Y, n, m-1));
    }
}
