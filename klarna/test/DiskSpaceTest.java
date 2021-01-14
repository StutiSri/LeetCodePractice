import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DiskSpaceTest {

    @Test
    public void test1() {
        assertTrue(DiskSpace.isWritable(1, 1, new HashSet<>()));
    }

    @Test
    public void test2() {
        assertFalse(DiskSpace.isWritable(1, 1, new HashSet<>(Collections.singletonList(1))));
    }

    @Test
    public void test3() {
        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 4))));
    }

    @Test
    public void test4() {
        assertFalse(DiskSpace.isWritable(4, 5, new HashSet<>(Arrays.asList(1, 4))));
    }

    @Test
    public void test5() {
        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(1, 2))));
    }

    @Test
    public void test6() {
        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(3, 4))));
    }

    @Test
    public void test7() {
        assertFalse(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(3, 1, 2, 4))));
    }

    @Test
    public void test8() {
        assertTrue(DiskSpace.isWritable(4, 2, new HashSet<>(Arrays.asList(7, 3, 1, 2, 4))));
    }

    @Test
    public void test9() {
        assertTrue(DiskSpace.isWritable(4, 2, null));
    }

}