import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FirstNegativeNumberInWindowOfSizeK {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime * 0.001);
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        Stack<Integer> negatives = new FirstNegativeNumberInWindowOfSizeK().negatives(arr, k);
        while (!negatives.empty()){
            Integer pop = negatives.pop();
            System.out.println(pop);
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);

    }

    private Stack<Integer> negatives(int[] arr, int k) {
        int i = arr.length - k;
        Stack<Integer> firstNegatives = new Stack<>();
        for(int index = i; index < arr.length; index++){
            if(arr[index] < 0){
                firstNegatives.push(arr[index]);
                i--;
                break;
            }
        }
        if(firstNegatives.size() == 0){
            firstNegatives.push(0);
            i--;
        }
        while (i > -1){
            if(arr[i] < 0){
                firstNegatives.push(arr[i]);
            }else {
                Integer previousResult = firstNegatives.peek();
                firstNegatives.push(previousResult);
            }
            i--;
        }
        return firstNegatives;
    }
}
