package answer.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsTest {
    private UniquePaths uniquePaths;

    @Before
    public void setUp() throws Exception {
        uniquePaths = new UniquePaths();
    }

    @Test
    public void uniquePaths1() {
        assertEquals(3, uniquePaths.uniquePaths(3, 2));
    }

    @Test
    public void uniquePaths2() {
        assertEquals(28, uniquePaths.uniquePaths(7, 3));
    }
}