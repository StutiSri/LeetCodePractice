public class SubsetSumProblem {
    public static void main(String[] args) {

        int[] arr = {5, 5, 5, 2, 1};
        int W = 9;

        System.out.println(subSetSum(arr, W, arr.length));
    }

    private static boolean subSetSum(int[] arr, int sum, int n) {
        boolean[][] t = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            t[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                }

            }
        }

        return t[n][sum];
    }
}
