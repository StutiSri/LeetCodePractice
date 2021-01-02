public class MatrixChainMultiplicationBottomUp {
    static int[][] t;
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
//        int[] arr = {40, 20, 30};
        t = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++){
            for (int j = 0; j <= arr.length; j++){
                t[i][j] = -1;
            }
        }
        System.out.println(mcm(arr, 1, arr.length-1));
    }

    private static int mcm(int[] arr, int i, int j) {
        if(i >= j){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
            int temp = mcm(arr, i, k) + mcm(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            ans = Math.min(temp, ans);
        }
        t[i][j] = ans;
        return ans;
    }
}
