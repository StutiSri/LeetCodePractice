import org.junit.jupiter.api.Test;

class MergeSortedArraysTest {
    @Test
    void shouldMergeSortedArrays() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6};

        int[] merge = new MergeSortedArrays().merge(arr1, arr2);
        for (int num : merge) {
            System.out.print(num + " ");
        }
    }
}