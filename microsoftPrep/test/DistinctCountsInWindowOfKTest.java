import org.junit.jupiter.api.Test;

import java.util.List;

class DistinctCountsInWindowOfKTest {
    @Test
    void test1() {
        int[] arr = {12, 17, 18, 19, 20, 25};
        List<Integer> distincts = new DistinctCountsInWindowOfK().findDistincts(arr, 3);

        assert distincts.get(0) == 3;
        assert distincts.get(1) == 3;
        assert distincts.get(2) == 3;
        assert distincts.get(3) == 3;
    }

    @Test
    void test2() {
        int[] arr = {12, 12, 18, 18, 20, 25};
        List<Integer> distincts = new DistinctCountsInWindowOfK().findDistincts(arr, 3);

        assert distincts.get(0) == 2;
        assert distincts.get(1) == 2;
        assert distincts.get(2) == 2;
        assert distincts.get(3) == 3;
    }

    @Test
    void test3() {
        int[] arr = {12, 12, 12, 12, 12, 12};
        List<Integer> distincts = new DistinctCountsInWindowOfK().findDistincts(arr, 3);

        assert distincts.get(0) == 1;
        assert distincts.get(1) == 1;
        assert distincts.get(2) == 1;
        assert distincts.get(3) == 1;
    }

    @Test
    void test4() {
        int[] arr = {12, 15, 16, 15, 21, 15};
        List<Integer> distincts = new DistinctCountsInWindowOfK().findDistincts(arr, 4);

        assert distincts.get(0) == 3;
        assert distincts.get(1) == 3;
        assert distincts.get(2) == 3;
    }
}