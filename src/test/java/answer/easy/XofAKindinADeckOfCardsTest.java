package answer.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class XofAKindinADeckOfCardsTest {
    private XofAKindinADeckOfCards xofAKindinADeckOfCards = new XofAKindinADeckOfCards();

    @Test
    public void hasGroupsSizeX1() {
        assertTrue(xofAKindinADeckOfCards.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
    }

    @Test
    public void hasGroupsSizeX2() {
        assertFalse(xofAKindinADeckOfCards.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
    }

    @Test
    public void hasGroupsSizeX3() {
        assertFalse(xofAKindinADeckOfCards.hasGroupsSizeX(new int[]{1}));
    }

    @Test
    public void hasGroupsSizeX4() {
        assertTrue(xofAKindinADeckOfCards.hasGroupsSizeX(new int[]{1, 1}));
    }

    @Test
    public void hasGroupsSizeX5() {
        assertTrue(xofAKindinADeckOfCards.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }
}