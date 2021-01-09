import java.util.Arrays;

public class TwoSum {
    private int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Arrays.sort(nums);
        int[] rev = new int[length];

        for (int i = 0; i < length; i++) {
            rev[i] = target - nums[i];
        }

        for (int i = 0; i < length; i++) {
            int targetNum = rev[i];
            for (int j = 0; j < length; j++) {
                if (i != j && targetNum == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] twoSum = new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i : twoSum) {
            System.out.print(i + " ");
        }
        twoSum = new TwoSum().twoSum(new int[]{3, 2, 4}, 6);
        for (int i : twoSum) {
            System.out.print(i + " ");
        }
        twoSum = new TwoSum().twoSum(new int[]{3, 3}, 6);
        for (int i : twoSum) {
            System.out.print(i + " ");
        }
    }
}
