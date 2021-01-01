public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 5};
        int sum = 10;

        System.out.println(minNumberOfCoins(coins, sum, coins.length));
    }

    private static int minNumberOfCoins(int[] coins, int sum, int n) {
        int[][] t = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }
        for (int j = 1; j <= sum; j++) {
            t[0][j] = Integer.MAX_VALUE - 1;
        }
        int firstCoin = coins[0];
        for (int j = 1; j <= sum; j++) {
            if (j % firstCoin == 0) {
                t[1][j] = j / firstCoin;
            } else {
                t[0][j] = Integer.MAX_VALUE - 1;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (coins[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.min((1 + t[i][j - coins[i - 1]]), t[i - 1][j]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        return t[n][sum];
    }
}
