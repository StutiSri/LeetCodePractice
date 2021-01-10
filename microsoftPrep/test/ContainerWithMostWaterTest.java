import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {
    @Test
    void test1() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        assert new ContainerWithMostWater().maxArea(height) == 49;
    }

    @Test
    void test2() {
        int[] height = new int[]{1, 1};

        assert new ContainerWithMostWater().maxArea(height) == 1;
    }

    @Test
    void test3() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7, 9, 7, 10};

        assert new ContainerWithMostWater().maxArea(height) == 64;
    }

    @Test
    void test4() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7, 9, 66, 66};

        assert new ContainerWithMostWater().maxArea(height) == 66;
    }

    @Test
    void test5() {
        int[] height = new int[]{1, 2, 1};

        assert new ContainerWithMostWater().maxArea(height) == 2;
    }
}