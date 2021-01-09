import java.util.HashMap;
import java.util.Map;

class FindTwoUnique {

    int[] findUnique(int[] nums) {
        Map<Integer, Integer> nonDuplicates = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            Integer existingValue = nonDuplicates.getOrDefault(num, null);
            if (existingValue == null) {
                nonDuplicates.put(num, index);
            } else {
                nonDuplicates.remove(num);
            }
        }

        int[] uniques = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : nonDuplicates.entrySet()) {
            uniques[index] = integerIntegerEntry.getKey();
            index++;
        }
        return uniques;
    }
}
