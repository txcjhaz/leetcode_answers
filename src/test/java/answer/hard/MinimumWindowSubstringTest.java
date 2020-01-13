package answer.hard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTest {
    private MinimumWindowSubstring minimumWindowSubstring;

    @Before
    public void before() {
        minimumWindowSubstring = new MinimumWindowSubstring();
    }

    @Test
    public void minWindow1() {
        assertEquals("BANC", minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void minWindow2() {
        assertEquals("", minimumWindowSubstring.minWindow("a", "b"));
    }

    @Test
    public void minWindow3() {
        assertEquals("", minimumWindowSubstring.minWindow("a", "aa"));
    }

    @Test
    public void minWindow4() {
        assertEquals("a", minimumWindowSubstring.minWindow("a", "a"));
    }

    @Test
    public void minWindow5() {
        assertEquals("aa", minimumWindowSubstring.minWindow("aa", "aa"));
    }

    @Test
    public void minWindow6() {
        assertEquals("baa", minimumWindowSubstring.minWindow("bbaac", "aba"));
    }


 /*   @Test
    public void test1() {
        assertTrue(minimumWindowSubstring.test("BANC", "ABC"));
    }

    @Test
    public void test2() {
        assertFalse(minimumWindowSubstring.test("BAN", "ABC"));
    }*/
}