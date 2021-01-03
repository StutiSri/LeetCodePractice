public class MaxSubArraySumOfSizeKWithNegativeNumbers {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime * 0.001);
        int[] arr = new int[]{-5, -4, -3, -2, -1, -10, -11, -3, -5};
        int k = 5;
        System.out.println(new MaxSubArraySumOfSizeKWithNegativeNumbers().maxSum(arr, 3));
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);
    }

    private int maxSum(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j;
        int currentSum = 0;
        for (j = 0; j < (i + k); j++) {
            if (currentSum < 0 && arr[j] > 0) {
                i = j;
                currentSum = arr[j];
                continue;
            } else if (currentSum > 0 && arr[j] < 0) {
                i = j + 1;
                currentSum = 0;
                continue;
            }
            currentSum += arr[j];
        }
        int maxSum = currentSum;
        while (j < n) {
            if (currentSum < 0 && arr[j] > 0) {
                currentSum = arr[j];
            } else if (currentSum > 0 && arr[j] < 0) {
                i = j + 1;
                currentSum = 0;
                for (; j < (i + k) && j < n; j++) {
                    if (currentSum < 0 && arr[j] > 0) {
                        i = j;
                        currentSum = arr[j];
                        continue;
                    } else if (currentSum > 0 && arr[j] < 0) {
                        i = j + 1;
                        currentSum = 0;
                        continue;
                    }
                    currentSum += arr[j];
                }
            } else {
                currentSum = currentSum + arr[j] - arr[i];
                i++;
            }
            maxSum = Math.max(maxSum, currentSum);
            j++;
        }
        return maxSum;
    }

}
