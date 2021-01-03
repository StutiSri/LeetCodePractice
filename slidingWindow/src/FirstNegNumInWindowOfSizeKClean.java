import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstNegNumInWindowOfSizeKClean {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime * 0.001);
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        Stack<Integer> negatives = new FirstNegNumInWindowOfSizeKClean().negatives(arr, k);
        while (!negatives.empty()) {
            System.out.println(negatives.pop());
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);

    }

    private Stack<Integer> negatives(int[] arr, int k) {
        Stack<Integer> firstNegatives = new Stack<>();
        Queue<Integer> negatives = new LinkedList<>();
        int i = 0;
        int j = 0;
        while (j < arr.length) {
            if (j == (i + k - 1)) {
                if (negatives.isEmpty()) {
                    firstNegatives.push(0);
                } else {
                    firstNegatives.push(negatives.peek());
                    negatives.remove(arr[i]);
                }
                i++;
            }
            if (arr[j] < 0) {
                negatives.add(arr[j]);
            }
            j++;
        }
        return firstNegatives;
    }
}
