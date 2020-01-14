package answer.hard;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SlidingWindowMaximumTest {
    private SlidingWindowMaximum slidingWindowMaximum;

    @Before
    public void setUp() throws Exception {
        slidingWindowMaximum = new SlidingWindowMaximum();
    }

    @Test
    public void maxSlidingWindow1() {
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7},
               slidingWindowMaximum.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    @Test
    public void maxSlidingWindow2() {
        assertArrayEquals(new int[]{},
                slidingWindowMaximum.maxSlidingWindow(new int[]{}, 3));
    }

    @Test
    public void maxSlidingWindow3() {
        assertArrayEquals(new int[]{1, -1},
                slidingWindowMaximum.maxSlidingWindow(new int[]{1, -1}, 1));
    }

    @Test
    public void maxSlidingWindow4() {
        assertArrayEquals(new int[]{7, 4},
                slidingWindowMaximum.maxSlidingWindow(new int[]{7, 2, 4}, 2));
    }
}