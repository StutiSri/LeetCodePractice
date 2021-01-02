public class EggDroppingProblemRecursive {
    public static void main(String[] args) {
        int e = 3;
        int f = 5;
        System.out.println(ways(e, f));
    }

    private static int ways(int e, int f) {
        if(e == 0 || f == 0){
            return 0;
        }
        if(e == 1){
            return f;
        }
        if(f == 1){
            return 1;
        }
        int numOfWays = Integer.MAX_VALUE;
        for (int i = 1; i <= f; i++){
            int temp = Math.max(ways(e - 1, i - 1), ways(e, f - i)) + 1;
            numOfWays = Math.min(numOfWays, temp);
        }
        return numOfWays;
    }
}
