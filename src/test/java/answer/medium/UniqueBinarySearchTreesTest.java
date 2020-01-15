package answer.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueBinarySearchTreesTest {
    private UniqueBinarySearchTrees uniqueBinarySearchTrees;

    @Before
    public void setUp() throws Exception {
        uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
    }

    @Test
    public void name() {
        assertEquals(3, uniqueBinarySearchTrees.numTrees(3));
    }

}