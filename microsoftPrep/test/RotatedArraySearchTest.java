import org.junit.jupiter.api.Test;

class RotatedArraySearchTest {
    @Test
    void rotateArraySearch1() {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int searchIndex = new RotatedArraySearch().search(arr, 0);
        assert searchIndex == 4;
    }

    @Test
    void rotateArraySearch2() {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int searchIndex = new RotatedArraySearch().search(arr, 4);
        assert searchIndex == 0;
    }

    @Test
    void rotateArraySearch3() {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int searchIndex = new RotatedArraySearch().search(arr, 5);
        assert searchIndex == 1;
    }

    @Test
    void rotateArraySearch4() {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int searchIndex = new RotatedArraySearch().search(arr, 6);
        assert searchIndex == 2;
    }

    @Test
    void rotateArraySearch5() {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int searchIndex = new RotatedArraySearch().search(arr, 2);
        assert searchIndex == 6;
    }

    @Test
    void rotateArraySearch6() {
        int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        int searchIndex = new RotatedArraySearch().search(arr, 3);
        assert searchIndex == -1;
    }

    @Test
    void rotateArraySearch7() {
        int[] arr = new int[]{3, 1};
        int searchIndex = new RotatedArraySearch().search(arr, 3);
        assert searchIndex == 0;
    }

    @Test
    void rotateArraySearch8() {
        int[] arr = new int[]{5, 1, 3};
        int searchIndex = new RotatedArraySearch().search(arr, 5);
        assert searchIndex == 0;
    }
}