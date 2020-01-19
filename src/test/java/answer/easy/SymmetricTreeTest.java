package answer.easy;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class SymmetricTreeTest {
    private SymmetricTree symmetricTree;

    @Before
    public void setUp() throws Exception {
        symmetricTree = new SymmetricTree();
    }

    @Test
    public void isSymmetric1() {
        SymmetricTree.TreeNode treeNode = new SymmetricTree.TreeNode(1);
        treeNode.left = new SymmetricTree.TreeNode(2);
        treeNode.right = new SymmetricTree.TreeNode(2);
        treeNode.left.left = new SymmetricTree.TreeNode(3);
        treeNode.left.right = new SymmetricTree.TreeNode(4);
        treeNode.right.left = new SymmetricTree.TreeNode(4);
        treeNode.right.right = new SymmetricTree.TreeNode(3);
        assertTrue(symmetricTree.isSymmetric(treeNode));
    }

    @Test
    public void isSymmetric2() {
        SymmetricTree.TreeNode treeNode = new SymmetricTree.TreeNode(1);
        treeNode.left = new SymmetricTree.TreeNode(2);
        treeNode.right = new SymmetricTree.TreeNode(2);
        treeNode.left.left = null;
        treeNode.left.right = new SymmetricTree.TreeNode(4);
        treeNode.right.left = null;
        treeNode.right.right = new SymmetricTree.TreeNode(3);
        assertFalse(symmetricTree.isSymmetric(treeNode));
    }
    @Test
    public void isSymmetric3() {
        SymmetricTree.TreeNode treeNode = new SymmetricTree.TreeNode(1);
        treeNode.left = new SymmetricTree.TreeNode(0);
        treeNode.right = null;
        assertFalse(symmetricTree.isSymmetric(treeNode));
    }

//    @Test
//    public void listIsSymmetric1() {
//        assertTrue(symmetricTree.listIsSymmetric(Arrays.asList(1, 2, 2, 1)));
//        assertTrue(symmetricTree.listIsSymmetric(Arrays.asList(1, 2, 3, 2, 1)));
//        assertTrue(symmetricTree.listIsSymmetric(Arrays.asList(1, 2, 1)));
//    }
//
//    @Test
//    public void listIsSymmetric2() {
//        assertFalse(symmetricTree.listIsSymmetric(Arrays.asList(1, 3, 2, 1)));
//        assertFalse(symmetricTree.listIsSymmetric(Arrays.asList(1, 4, 3, 2, 1)));
//        assertFalse(symmetricTree.listIsSymmetric(Arrays.asList(1, 2, 3)));
//        assertFalse(symmetricTree.listIsSymmetric(Collections.singletonList(1)));
//
//    }
}