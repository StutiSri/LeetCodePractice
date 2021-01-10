import org.junit.jupiter.api.Test;

class ParenthesesValidatorTest {
    @Test
    void test1() {
        boolean valid = new ParenthesesValidator().isValid("[]");
        assert valid;
        System.out.println(valid);
    }

    @Test
    void test2() {
        boolean valid = new ParenthesesValidator().isValid("[}");
        assert !valid;
        System.out.println(valid);
    }

    @Test
    void test3() {
        boolean valid = new ParenthesesValidator().isValid("[()(){}]");
        assert valid;
        System.out.println(valid);
    }

    @Test
    void test4() {
        boolean valid = new ParenthesesValidator().isValid("[{()}{()}]");
        assert valid;
        System.out.println(valid);
    }

    @Test
    void test5() {
        boolean valid = new ParenthesesValidator().isValid("[(({})]");
        assert !valid;
        System.out.println(valid);
    }

    @Test
    void test6() {
        boolean valid = new ParenthesesValidator().isValid("[({)}]");
        assert !valid;
        System.out.println(valid);
    }

    @Test
    void test7() {
        boolean valid = new ParenthesesValidator().isValid("");
        assert valid;
        System.out.println(valid);
    }

    @Test
    void test8() {
        boolean valid = new ParenthesesValidator().isValid("[({)");
        assert !valid;
        System.out.println(valid);
    }
}