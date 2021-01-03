public class MaxSubArraySumOfSizeK {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime * 0.001);
        int[] arr = new int[]{5, 4, 3, 2, 1, 10, 11, 3, 5};
        int k = 5;
        System.out.println(new MaxSubArraySumOfSizeK().maxSum(arr, 3));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);
    }

    private int maxSum(int[] arr, int k) {
        int maxSum = 0;
        int i = 0;
        int j;
        int currentSum = 0;
        for (j = 0; j < k; j++){
            currentSum += arr[j];
        }
        while(j < arr.length){
            currentSum = currentSum - arr[i] + arr[j];
            maxSum = Math.max(maxSum, currentSum);
            i++;
            j++;
        }
        return maxSum;
    }
}
