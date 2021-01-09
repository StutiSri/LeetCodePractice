import org.junit.jupiter.api.Test;

import java.util.List;

class CommonIn3SortedArrayTest {
    @Test
    void test1() {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int[] nums2 = {5, 6, 7, 8};
        int[] nums3 = {2, 5, 6, 7, 8, 9};

        List<Integer> common = new CommonIn3SortedArray().findCommon(nums1, nums2, nums3);
        assert common.get(0) == 5;
        assert common.get(1) == 6;
        assert common.get(2) == 7;

    }

    @Test
    void test2() {
        int[] nums1 = {1};
        int[] nums2 = {5, 6, 7, 8};
        int[] nums3 = {2, 5, 6, 7, 8, 9};

        List<Integer> common = new CommonIn3SortedArray().findCommon(nums1, nums2, nums3);
        assert common.size() == 0;

    }

    @Test
    void test3() {
        int[] nums1 = {1, 9, 17, 19, 25};
        int[] nums2 = {9, 19, 25, 30};
        int[] nums3 = {12, 17, 18, 19, 20, 25};

        List<Integer> common = new CommonIn3SortedArray().findCommon(nums1, nums2, nums3);
        assert common.get(0) == 19;
        assert common.get(1) == 25;

    }

    @Test
    void test4() {
        int[] nums1 = {1, 9, 17, 19, 25};
        int[] nums2 = {};
        int[] nums3 = {12, 17, 18, 19, 20, 25};

        List<Integer> common = new CommonIn3SortedArray().findCommon(nums1, nums2, nums3);
        assert common.size() == 0;

    }

}