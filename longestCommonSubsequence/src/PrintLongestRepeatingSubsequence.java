public class PrintLongestRepeatingSubsequence {
    public static void main(String[] args) {
        String X = "AABEBCDD";
        System.out.println(lrs(X.toCharArray(), X.length()));
    }

    private static String lrs(char[] X, int n) {
        int[][] t = new int[n + 1][n + 1];
        String[][] seq = new String[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
            seq[i][0] = "";
            t[0][i] = 0;
            seq[0][i] = "";
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (X[i - 1] == X[j - 1] && i != j) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                    seq[i][j] = seq[i - 1][j - 1] + X[i - 1];
                } else {
                    if (t[i - 1][j] > t[i][j - 1]) {
                        seq[i][j] = seq[i - 1][j];
                        t[i][j] = t[i - 1][j];
                    } else {
                        seq[i][j] = seq[i][j - 1];
                        t[i][j] = t[i][j - 1];
                    }
                }
            }
        }
        return seq[n][n];
    }
}
