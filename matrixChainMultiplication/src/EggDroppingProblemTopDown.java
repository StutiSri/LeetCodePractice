public class EggDroppingProblemTopDown {

    public static void main(String[] args) {
        int e = 3;
        int f = 5;
        System.out.println(ways(e, f));
    }

    private static int ways(int e, int f) {
        int[][] t = new int[e + 1][f + 1];
        for (int i = 0; i <= e; i++) {
            t[i][0] = 0;
            t[i][1] = 1;
        }
        for (int i = 0; i <= f; i++) {
            t[0][i] = 0;
            t[1][i] = i;
        }
        int numOfWays = Integer.MAX_VALUE;
        for (int i = 1; i <= f; i++) {
            int temp = Math.max(t[e - 1][i - 1], t[e][f - i]) + 1;
            numOfWays = Math.min(temp, numOfWays);
        }
        t[e][f] = numOfWays;
        return numOfWays;
    }
}
