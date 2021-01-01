public class CountOfSubsetProblem {

    private static int countOfSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            t[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }

    public static void main(String[] args) {

        int[] arr = {10, 1, 4, 3, 4};

        System.out.println(countOfSubsetSum(arr, 14));
    }
}
