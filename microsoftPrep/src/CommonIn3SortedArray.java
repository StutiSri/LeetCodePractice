import java.util.ArrayList;
import java.util.List;

public class CommonIn3SortedArray {
    public List<Integer> findCommon(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> commonListForOneTwo = commonList(nums1, nums2);
        int size = commonListForOneTwo.size();
        int[] comms = new int[size];
        for (int i = 0; i < size; i++) {
            comms[i] = commonListForOneTwo.get(i);
        }
        return commonList(comms, nums3);
    }

    private List<Integer> commonList(int[] nums1, int[] nums2) {
        int i1 = 0;
        int j1 = nums1.length - 1;
        int i2 = 0;
        int j2 = nums2.length - 1;
        List<Integer> commonArr = new ArrayList<>();

        while (i1 <= j1 && i2 <= j2) {
            int currentInNums1 = nums1[i1];
            int currentInNums2 = nums2[i2];
            if (currentInNums1 == currentInNums2) {
                commonArr.add(currentInNums1);
                i1++;
                i2++;
                continue;
            }
            if (currentInNums1 > nums2[i2]) {
                int closestMidForNum = findClosest(nums2, i2, j2, currentInNums1);
                if (closestMidForNum == -1) {
                    return commonArr;
                }
                if (currentInNums1 == nums2[closestMidForNum]) {
                    commonArr.add(currentInNums1);
                    i1++;
                    i2 = closestMidForNum + 1;
                } else {
                    i2 = closestMidForNum;
                }
            } else {
                int closestMidForNum = findClosest(nums1, i1, j1, currentInNums2);
                if (closestMidForNum == -1) {
                    return commonArr;
                }
                if (currentInNums2 == nums1[closestMidForNum]) {
                    commonArr.add(currentInNums2);
                    i2++;
                    i1 = closestMidForNum + 1;
                } else {
                    i1 = closestMidForNum;
                }
            }
        }
        return commonArr;
    }

    private int findClosest(int[] arr, int start, int end, int key) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (mid >= 1 && arr[mid] > key && arr[mid - 1] < key) {
            return mid;
        }
        if (mid < (arr.length - 1) && arr[mid] < key && arr[mid + 1] > key) {
            return mid;
        }
        if (key > arr[mid]) {
            return findClosest(arr, mid + 1, end, key);
        }
        return findClosest(arr, start, mid - 1, key);
    }
}
