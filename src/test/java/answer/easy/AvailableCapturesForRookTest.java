package answer.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvailableCapturesForRookTest {
    private AvailableCapturesForRook availableCapturesForRook = new AvailableCapturesForRook();

    @Test
    public void numRookCaptures() {
        char[][] chs  = new char[8][8];
        chs[1][3] = 'p';
        chs[2][3] = 'R';
        chs[2][7] = 'p';
        chs[5][3] = 'p';
        assertEquals(3, availableCapturesForRook.numRookCaptures(chs));
    }

    @Test
    public void numRookCaptures2() {
        char[][] chs  = new char[8][8];
        chs[2][2] = 'B';
        chs[2][3] = 'R';
        chs[2][4] = 'B';
        chs[1][3] = 'B';
        chs[3][3] = 'B';
        assertEquals(0, availableCapturesForRook.numRookCaptures(chs));
    }
}