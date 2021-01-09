import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DistinctCountsInWindowOfK {
    List<Integer> findDistincts(int[] arr, int k) {
        int length = arr.length;
        List<Integer> distincts = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();
        int distinctCounts = 0;
        int index = 0;
        int i = 0;
        int j = 0;
        for (; j < k; j++) {
            int currentNum = arr[j];
            int currentCount = counts.getOrDefault(currentNum, 0);
            if (currentCount == 0) {
                distinctCounts++;
            }
            currentCount++;
            counts.put(currentNum, currentCount);
        }
        distincts.add(distinctCounts);
        while (j < length) {
            if (arr[i] != arr[j]) {
                int numberToBeRemoved = arr[i];
                int currentCountOfNumberToBeRemoved = counts.get(numberToBeRemoved);
                if (currentCountOfNumberToBeRemoved == 1) {
                    counts.remove(numberToBeRemoved);
                    distinctCounts--;
                } else {
                    counts.put(numberToBeRemoved, currentCountOfNumberToBeRemoved - 1);
                }
                int currentNum = arr[j];
                int currentCountOfNewNumber = counts.getOrDefault(currentNum, 0);
                if (currentCountOfNewNumber == 0) {
                    distinctCounts++;
                }
                currentCountOfNewNumber++;
                counts.put(currentNum, currentCountOfNewNumber);
            }
            distincts.add(distinctCounts);
            i++;
            j++;
        }
        return distincts;
    }
}
