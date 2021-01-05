class RotatedArraySearch {
    int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        return index(nums, target, start, end);
    }

    private int index(int[] arr, int k, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (arr[start] <= arr[mid]) {
            if (k <= arr[mid] && arr[start] <= k) {
                return index(arr, k, start, mid - 1);
            }
            return index(arr, k, mid + 1, end);
        }
        if (arr[end] >= k && arr[mid] <= k) {
            return index(arr, k, mid + 1, end);
        }
        return index(arr, k, start, mid - 1);
    }
}
