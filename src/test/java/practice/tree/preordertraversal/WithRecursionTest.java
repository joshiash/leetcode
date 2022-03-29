package practice.tree.preordertraversal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import practice.tree.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WithRecursionTest {

    private static final WithRecursion unit = new WithRecursion();

    @Test
    public void shouldReturnPreorderTraversal()
    {
        List<Integer> expectedResult = Arrays.asList(1,2,3);
        TreeNode treeNode = createTree();
        List<Integer> result = unit.preorderTraversal(treeNode);
        Assertions.assertIterableEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnEmptyListForEmptyTreePreorderTraversal()
    {
        List<Integer> expectedResult = Collections.emptyList();
        List<Integer> result = unit.preorderTraversal(null);
        Assertions.assertIterableEquals(expectedResult, result);
    }

    private TreeNode createTree() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        return node1;
    }
}
