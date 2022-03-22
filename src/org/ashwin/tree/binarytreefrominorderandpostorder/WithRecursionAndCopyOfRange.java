package org.ashwin.tree.binarytreefrominorderandpostorder;

import java.util.Arrays;

public class WithRecursionAndCopyOfRange {

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
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

    public static int findIndex(int[] array, int value) {
        for(int i=0; i<array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode tree = buildTree(inorder, postorder);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
