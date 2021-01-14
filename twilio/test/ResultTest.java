import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultTest {
    @Test
    void test1() {
        List<String> codes = Arrays.asList("TWLO", "CODE", "HTCH");
        List<String> numbers = Arrays.asList("+17474824380",
                "+1415123456",
                "+14157088956",
                "+919810155555",
                "+1415123456",
                "+15109926333",
                "+1415123456");
        List<String> vanity = Result.vanity(codes, numbers);
        assertEquals(3, vanity.size());
        assertEquals("+14157088956", vanity.get(0));
        assertEquals("+15109926333", vanity.get(1));
        assertEquals("+17474824380", vanity.get(2));
    }

    @Test
    void test2() {
        List<String> codes = Arrays.asList("JAZZ",
                "ZIZZ",
                "BUZZ",
                "FUZZ",
                "BAZZ",
                "FIZZ",
                "HAJJ",
                "JUJU",
                "QUIZ",
                "JEEZ",
                "RAZZ",
                "TIZZ",
                "JEUX",
                "JINX",
                "JACK",
                "JOCK",
                "JUMP");
        List<String> numbers = Arrays.asList(
                "+1415123456" ,
                "+15109926333" ,
                "+919810155555");
        List<String> vanity = Result.vanity(codes, numbers);
        assertEquals(0, vanity.size());
    }
}