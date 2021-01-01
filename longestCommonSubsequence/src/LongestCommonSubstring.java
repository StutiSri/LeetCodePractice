public class LongestCommonSubstring {
    public static void main(String[] args) {
        String X = "abcde";
        String Y = "abcde";
        System.out.println(lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    private static int lcs(char[] X, char[] Y, int m, int n) {
        int[][] t = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            t[i][0] = 0;
        }
        for(int i = 0; i < n; i++){
            t[0][i] = 0;
        }
        int maxLength = Integer.MIN_VALUE;
        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if(X[i - 1] == Y[j - 1])     {
                    t[i][j] = 1 + t[i-1][j-1];
                    if(t[i][j] > maxLength){
                        maxLength = t[i][j];
                    }
                }else {
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        return maxLength;
    }
}
