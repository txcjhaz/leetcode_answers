package answer.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularExpressionMatchingTest {
    private RegularExpressionMatching regularExpressionMatching;

    @Before
    public void setUp() throws Exception {
        regularExpressionMatching = new RegularExpressionMatching();
    }

    @Test
    public void isMatch1() {
        assertFalse(regularExpressionMatching.isMatch("aa", "a"));
    }

    @Test
    public void isMatch2() {
        assertFalse(regularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
    }

    @Test
    public void isMatch3() {
        assertTrue(regularExpressionMatching.isMatch("aab", "c*a*b"));
    }

    @Test
    public void isMatch4() {
        assertTrue(regularExpressionMatching.isMatch("aaa", "ab*ac*a"));
    }

}