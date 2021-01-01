public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "abc";
        String Y = "abc";

        System.out.println(lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
    }

    private static String lcs(char[] X, char[] Y, int n, int m) {
        int[][] t = new int[n + 1][m + 1];
        String[][] seq = new String[n + 1][m + 1];
        for (int i = 0; i <= n; i++){
            t[i][0] = 0;
            seq[i][0] = "";
        }
        for (int i = 0; i <= m; i++){
            t[0][i] = 0;
            seq[0][i] = "";
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if(X[i-1] == Y[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                    seq[i][j] =  seq[i-1][j-1] + X[i-1];
                }else{
                    if(t[i-1][j] > t[i][j-1]){
                        t[i][j] = t[i-1][j];
                        seq[i][j] = seq[i-1][j];
                    }else{
                        t[i][j] = t[i][j-1];
                        seq[i][j] = seq[i][j-1];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                System.out.print(seq[i][j] + " ");
            }
            System.out.println();
        }
        return seq[n][m];
    }
}
