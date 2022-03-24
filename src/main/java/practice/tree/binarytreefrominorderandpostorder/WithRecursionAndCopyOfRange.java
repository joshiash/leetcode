package practice.tree.binarytreefrominorderandpostorder;

import practice.tree.TreeNode;

import java.util.Arrays;

/*
* Time complexity O(n*n)
* */
public class WithRecursionAndCopyOfRange {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 1 && inorder.length == 1) {
            return new TreeNode(postorder[0]);
        }

        int rootNodeValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootNodeValue);

        int rootNodeIndex = findIndex(inorder, rootNodeValue);
        int[] inorderLeftSubTree = Arrays.copyOfRange(inorder, 0 , rootNodeIndex);
        int[] inorderRightSubTree = Arrays.copyOfRange(inorder, rootNodeIndex+1 , inorder.length);
        int[] postorderLeftSubTree = Arrays.copyOfRange(postorder, 0 , rootNodeIndex);
        int[] postorderRightSubTree = Arrays.copyOfRange(postorder, rootNodeIndex , postorder.length-1);

        root.left = buildTree(inorderLeftSubTree,postorderLeftSubTree);
        root.right = buildTree(inorderRightSubTree,postorderRightSubTree);
        return root;
    }

    public int findIndex(int[] array, int value) {
        for(int i=0; i<array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return 0;
    }
}
