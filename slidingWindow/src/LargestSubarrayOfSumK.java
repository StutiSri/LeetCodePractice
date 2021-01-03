public class LargestSubarrayOfSumK {
    public static void main(String[] args) {
        int[] arr = new int[]{84, 84, 79, 2, 1, 1};
        System.out.println(lengthOfLargestSubArray(arr, 83));
    }

    private static int lengthOfLargestSubArray(int[] arr, int k) {
        int n = arr.length;
        int maxLength = Integer.MIN_VALUE;
        int currentSum = 0;
        int i = 0;
        int j = 0;
        while (j < n){
            currentSum += arr[j];
            if(currentSum == k){
                maxLength = Math.max(maxLength, (j - i + 1));
            }else if(currentSum > k){
                while (currentSum > k){
                    currentSum -= arr[i];
                    i++;
                }
            }
            j++;
        }
        return maxLength;
    }
}
