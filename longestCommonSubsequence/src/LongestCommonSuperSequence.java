public class LongestCommonSuperSequence {
    public static void main(String[] args) {
        String X = "abcdef";
        String Y = "abcdeg";
        System.out.println(lcss(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    private static int lcss(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            t[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }
        return m + n - t[n][m];
    }
}
