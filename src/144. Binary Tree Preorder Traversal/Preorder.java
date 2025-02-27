import java.util.ArrayList;
import java.util.List;

class Preorder {

    /* 
     * Runtime 0ms Beats 100%
     * Memory 41.62MB Beats 63.57%
     */

    List<Integer> out = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return out;

        out.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return out;
    }

    class TreeNode {
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
