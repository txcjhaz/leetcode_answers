package answer.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeWaysTest {
    private DecodeWays decodeWays;

    @Before
    public void setUp() throws Exception {
        decodeWays = new DecodeWays();
    }

    @Test
    public void numDecodings1() {
        assertEquals(3, decodeWays.numDecodings("226"));
    }

    @Test
    public void numDecodings2() {
        assertEquals(2, decodeWays.numDecodings("12"));
    }

    @Test
    public void numDecodings3() {
        assertEquals(216, decodeWays.numDecodings("12124124124124"));
    }

    @Test
    public void numDecodings4() {
        assertEquals(1, decodeWays.numDecodings("10"));
    }

    @Test
    public void numDecodings5() {
        assertEquals(1, decodeWays.numDecodings("27"));
    }

    @Test
    public void numDecodings6() {
        assertEquals(0, decodeWays.numDecodings("01"));
    }

    @Test
    public void numDecodings7() {
        assertEquals(0, decodeWays.numDecodings("00"));
    }

    @Test
    public void numDecodings8() {
        assertEquals(0, decodeWays.numDecodings("230"));
    }
}