package palindrome;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String X = "agbca";
        System.out.println(lps(X.toCharArray(), X.length()));
    }

    private static int lps(char[] X, int n) {
        char[] Y = new char[n];
        for (int i = n-1, j = 0; i > -1; i--, j++){
            Y[j] = X[i];
        }
        int[][] t = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++){
            t[i][0] = 0;
        }
        for (int i = 0; i <= n; i++){
            t[0][i] = 0;
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if(X[i-1] == Y[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][n];
    }
}
