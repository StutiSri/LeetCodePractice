import org.junit.jupiter.api.Test;

class MergeTwoUnsortedArrayTest {
    @Test
    void test1() {
        int[] arr1 = {12, 11, 13, 5, 6, 7};
        int[] arr2 = {23, 9, 13, 15, 60, 27};

        int[] expectedArr = {5, 6, 7, 9, 11, 12, 13, 13, 15, 23, 27, 60};

        int[] arr = new MergeTwoUnsortedArray().mergeArrays(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            assert expectedArr[i] == arr[i];
        }
    }

    @Test
    void test2() {
        int[] arr1 = {12};
        int[] arr2 = {23, 9, 13, 15, 60, 27};

        int[] expectedArr = {9, 12, 13, 15, 23, 27, 60};

        int[] arr = new MergeTwoUnsortedArray().mergeArrays(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            assert expectedArr[i] == arr[i];
        }
    }

    @Test
    void test3() {
        int[] arr1 = {12};
        int[] arr2 = {23};

        int[] expectedArr = {12, 23};

        int[] arr = new MergeTwoUnsortedArray().mergeArrays(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            assert expectedArr[i] == arr[i];
        }
    }
}