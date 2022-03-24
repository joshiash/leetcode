package practice.tree.binarytreefrominorderandpostorder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.tree.TreeNode;

public class WithRecursionAndCopyOfRangeTest {

    private static final WithRecursionAndCopyOfRange unit = new WithRecursionAndCopyOfRange();;


    @Test
    public void shouldGetTreeFromInorderAndPostOrder() {
        final String expectedResult = "3,9,20,15,7,";
        final int[] inorder = new int[]{9,3,15,20,7};
        final int[] postorder = new int[]{9,15,7,20,3};
        final TreeNode treeNode = unit.buildTree(inorder, postorder);
        Assertions.assertEquals(expectedResult,printTree(treeNode));
    }

    private String printTree(TreeNode tree){
        String value;
        if(tree == null) {
            return "";
        }
        value = tree.val+ "," +printTree(tree.left) +printTree(tree.right);
        return value;
    }
}
