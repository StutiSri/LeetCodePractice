public class Kanpsack01Memo {

    static Integer[][] t = new Integer[1001][1001];

    private static int knapsack(int[] wt, int[] val, int W, int n) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if(t[W][n] != null){
           return t[W][n];
        }

        if (wt[n - 1] > W) {
            return t[W][n] = knapsack(wt, val, W, n - 1);
        }

        int valOnIncluding = val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1);
        int valOnExcluding = knapsack(wt, val, W, n - 1);
        int max = Math.max(valOnIncluding, valOnExcluding);
        if (max == valOnIncluding) {
            System.out.print(wt[n - 1] + " ");
        }
        return t[W][n] = max;
    }

    public static void main(String[] args) {
        int[] wt = {5, 4, 3, 2, 1};
        int[] val = {14, 13, 11, 12, 13};
        int W = 9;

        System.out.println(knapsack(wt, val, W, wt.length));
    }
}
