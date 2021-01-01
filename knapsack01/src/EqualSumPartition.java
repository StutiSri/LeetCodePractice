public class EqualSumPartition {

    private static boolean equalSumPartition(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }

        if(sum%2 != 0){
            return false;
        }

        int sum1 = sum/2;
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][sum1 + 1];

        for (int i = 0; i <= n; i++){
            t[i][0] = true;
        }

        for (int i = 1; i <= sum1; i++){
            t[0][i] = false;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= sum1; j++){
                if(arr[i - 1] > j){
                    t[i][j] = t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
                }
            }
        }

        return t[n][sum1];
    }

    public static void main(String[] args) {

        int[] arr = {10, 5, 4, 5, 4};

        System.out.println(equalSumPartition(arr));
    }
}
