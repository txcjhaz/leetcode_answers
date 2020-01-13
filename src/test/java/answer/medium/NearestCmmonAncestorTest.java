package answer.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class NearestCmmonAncestorTest {

    @Test
    public void testLowestCommonAncestor1() {
        TreeNode tree = NearestCmmonAncestor.parseTree("[3,5,1,6,2,0,8,null,null,7,4]");
        int result = new NearestCmmonAncestor().lowestCommonAncestor(tree,
                        new TreeNode(1),
                        new TreeNode(5)).val;
        assertEquals(3, result);
    }

    @Test
    public void testLowestCommonAncestor2() {
        TreeNode tree = NearestCmmonAncestor.parseTree("[3,5,1,6,2,0,8,null,null,7,4]");
        int result = new NearestCmmonAncestor().lowestCommonAncestor(tree,
                new TreeNode(4),
                new TreeNode(5)).val;
        assertEquals(5, result);
    }

    @Test
    public void testLowestCommonAncestor3() {
        TreeNode tree = NearestCmmonAncestor.parseTree("[1,2]");
        int result = new NearestCmmonAncestor().lowestCommonAncestor(tree,
                new TreeNode(1),
                new TreeNode(2)).val;
        assertEquals(1, result);
    }
}