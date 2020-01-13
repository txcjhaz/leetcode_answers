package answer.easy;

import static org.junit.Assert.assertEquals;

public class GuessNumbersTest {

    @org.junit.Test
    public void game() {
        assertEquals(3,
                new GuessNumbers().game(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }
}