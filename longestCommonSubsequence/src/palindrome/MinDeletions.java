package palindrome;

public class MinDeletions {
    public static void main(String[] args) {
        String X = "agbcba";
        System.out.println(minDeletions(X.toCharArray(), X.length()));
    }

    private static int minDeletions(char[] X, int n) {
        char[] Y = new char[n];
        for (int i = 0, j = n - 1; j > -1; i++, j--) {
            Y[j] = X[i];
        }
        int[][] t = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
            t[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++){
                if(X[i-1] == Y[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }
        return n - t[n][n];
    }
}
