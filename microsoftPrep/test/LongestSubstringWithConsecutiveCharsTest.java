import org.junit.jupiter.api.Test;

class LongestSubstringWithConsecutiveCharsTest {
    @Test
    void test1() {
        String test = "abcabcdefabc";
        assert new LongestSubstringWithConsecutiveChars().lswcc(test) == 6;
    }

    @Test
    void test2() {
        String test = "zabcd";
        assert new LongestSubstringWithConsecutiveChars().lswcc(test) == 5;
    }

    @Test
    void test3() {
        String test = "dfabck";
        assert new LongestSubstringWithConsecutiveChars().lswcc(test) == 3;
    }
}