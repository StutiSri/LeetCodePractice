import java.util.*;

public class MaxNumberInEachSubArrayOfSizeK {
    public class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer int1, Integer int2) {
            return int1 > int2 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime * 0.001);
        int[] arr = new int[]{12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        Queue<Integer> negatives = new MaxNumberInEachSubArrayOfSizeK().maxs(arr, k);
        while (!negatives.isEmpty()) {
            Integer pop = negatives.remove();
            System.out.println(pop);
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) * 0.001);
    }

    private Queue<Integer> maxs(int[] arr, int k) {
        Queue<Integer> allMaxes = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new IntegerComparator());
        int n = arr.length;
        int i = 0;
        int j = 0;
        for (; j < k; j++) {
            pq.add(arr[j]);
        }
        Integer currentMax = pq.peek();
        allMaxes.add(currentMax);
        do {
            if (currentMax == arr[i]) {
                pq.remove(currentMax);
                currentMax = pq.peek();
            }
            if (arr[j] > currentMax) {
                currentMax = arr[j];
            }
            allMaxes.add(currentMax);
            pq.add(arr[j]);
            j++;
            i++;
        } while (j < n);

        return allMaxes;
    }
}
