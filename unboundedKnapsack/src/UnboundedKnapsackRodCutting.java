public class UnboundedKnapsackRodCutting {
    public static void main(String[] args) {
        int[] wt = {5, 4, 3, 2, 1};
        int[] val = {14, 13, 11, 12, 13};
        int W = 9;

        System.out.println(unboundedKnapsack(wt, val, W, wt.length));
    }

    private static int unboundedKnapsack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int j = 1; j <= W; j++) {
            t[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (wt[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max((val[i - 1] + t[i][j - wt[i - 1]]), t[i - 1][j]);
                }
            }
        }
        return t[n][W];
    }
}
