public class PalindromePartitioningRecursive {
    public static void main(String[] args) {
        String str = "nitik";
        System.out.println(pp(str, 0, str.length() - 1));
    }

    private static int pp(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        int numberOfPartitions = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int temp = 1 + pp(str, i, k) + pp(str, k + 1, j);
            numberOfPartitions = Math.min(temp, numberOfPartitions);
        }
        return numberOfPartitions;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        int midIndex = start + (end - start) / 2;
        for (int i = start, j = end; i <= midIndex; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
