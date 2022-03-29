package practice.tree.preordertraversal;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WithStack {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            results.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return results;
    }
}
