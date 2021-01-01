public class MinimumSubsetSumDifference {

    public static void main(String[] args) {

        int[] arr = {10, 11, 13, 15, 10};

        System.out.println(minimumSubsetSumDifference(arr));
    }

    private static int minimumSubsetSumDifference(int[] arr) {
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        int n = arr.length;
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

        int minSumDiff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (t[n][j]) {
                int sumDiff = Math.abs(2 * j - sum);
                if (sumDiff < minSumDiff) {
                    minSumDiff = sumDiff;
                }
            }
        }

        return minSumDiff;
    }
}
