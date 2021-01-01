public class MinimumNumberOfInsAndDelForStringAtoB {
    public static void main(String[] args) {
        String X = "hsedafpg";
        String Y = "heapse";
        int lcs = lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length());
        int deletions = X.length() - lcs;
        int insertions = Y.length() - lcs;
        System.out.println(deletions + " " + insertions);
    }

    private static int lcs(char[] X, char[] Y, int n, int m) {
        int[][] t = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++){
            t[i][0] = 0;
        }
        for(int i = 0; i <= m; i++){
            t[0][i] = 0;
        }
        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (X[i-1] == Y[j-1]){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}
