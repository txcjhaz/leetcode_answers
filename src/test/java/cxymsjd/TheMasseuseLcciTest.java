package cxymsjd;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TheMasseuseLcciTest {

    @Test
    public void massage1() {
        assertEquals(4, TheMasseuseLcci.massage(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void massage2() {
        assertEquals(12, TheMasseuseLcci.massage(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    public void massage3() {
        assertEquals(12, TheMasseuseLcci.massage(new int[]{2, 1, 4, 5, 3, 1, 1, 3}));
    }

    @Test
    public void massage4() {
        assertEquals(0, TheMasseuseLcci.massage(new int[]{}));
    }
}