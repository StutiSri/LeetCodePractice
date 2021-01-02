public class EggDroppingProblemMemoized {
    static int[][] t;

    public static void main(String[] args) {
        int e = 3;
        int f = 5;
        t = new int[e + 1][f + 1];
        for (int i = 0; i <= e; i++) {
            for (int j = 0; j <= f; j++) {
                t[i][j] = -1;
            }
        }
        System.out.println(ways(e, f));
    }

    private static int ways(int e, int f) {
        if (t[e][f] != -1) {
            return t[e][f];
        }
        if (f == 0 || f == 1 || e == 1) {
            return f;
        }
        int numOfWays = Integer.MAX_VALUE;
        for (int i = 1; i <= f; i++) {
            int temp = Math.max(ways(e - 1, i - 1), ways(e, f - i)) + 1;
            numOfWays = Math.min(temp, numOfWays);
        }
        t[e][f] = numOfWays;
        return numOfWays;
    }
}
