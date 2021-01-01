public class CountOfSubsetSumWithGivenDiff {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 1};

        System.out.println(numberOfSubsetsWithGivenDiff(arr, 3));
    }

    private static int numberOfSubsetsWithGivenDiff(int[] arr, int sum) {
        if (arr.length == 0) {
            return 0;
        }

        int totalSum = 0;
        for (int item : arr) {
            totalSum += item;
        }

        if(sum > totalSum){
            return 0;
        }

        if ((totalSum + sum) % 2 != 0) {
            return 0;
        }

        int sum1 = (totalSum + sum) / 2;

        int n = arr.length;
        int[][] t = new int[n + 1][sum1 + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }
        for (int j = 1; j <= sum1; j++) {
            t[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum1; j++) {
                if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                }
            }
        }
        return t[n][sum1];
    }
}
