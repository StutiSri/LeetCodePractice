import org.junit.jupiter.api.Test;

class FindTwoUniqueTest {

    @Test
    void test1() {
        int[] nums = {1, 1, 2, 4, 4, 5, 3, 3};
        int[] expectedUniques = {2, 5};
        int[] uniques = new FindTwoUnique().findUnique(nums);

        assert expectedUniques[0] == uniques[0];
        assert expectedUniques[1] == uniques[1];
    }

    @Test
    void test2() {
        int[] nums = {1, 1, 2, 3};
        int[] expectedUniques = {2, 3};
        int[] uniques = new FindTwoUnique().findUnique(nums);

        assert expectedUniques[0] == uniques[0];
        assert expectedUniques[1] == uniques[1];
    }
}