public class Kanpsack01TopDown {

    private static int knapsack(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        Integer[][] t = new Integer[n + 1][W + 1];

        for(int i = 0; i < W + 1; i++){
            t[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++){
            t[i][0] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i - 1] > j){
                    t[i][j] = t[i - 1][j];
                }else{
                    t[i][j] = Math.max((val[i - 1] + t[i - 1][j - wt[i - 1]]), t[i-1][j]);
                }
            }
        }

        return t[n][W];
    }

    public static void main(String[] args) {
        int[] wt = {5, 4, 3, 2, 1};
        int[] val = {14, 13, 11, 12, 13};
        int W = 9;

        System.out.println(knapsack(wt, val, W, wt.length));
    }
}
