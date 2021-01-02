public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
//        int[] arr = {40, 20, 30};
        System.out.println(mcm(arr, 1, arr.length-1));
    }

    private static int mcm(int[] arr, int i, int j) {
        if(i >= j){
            return 0;
        }
        int answer = Integer.MAX_VALUE;
        for (int k = i; k < j; k++){
            int temp = mcm(arr, i, k) + mcm(arr, k+1, j) + arr[i-1]*arr[k]*arr[j];
            answer = Math.min(temp, answer);
        }
        return answer;
    }
}
