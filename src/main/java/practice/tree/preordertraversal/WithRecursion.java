package practice.tree.preordertraversal;

import practice.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class WithRecursion {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
}
