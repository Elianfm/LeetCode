import java.util.ArrayList;
import java.util.List;

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

class PostOrder {

    /*
     * Runtime: 0 ms Beats 100%
     * Memory: 41.52 MB Beats 81.05%
     */

    List<Integer> out = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return out;

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        out.add(root.val);

        return out;
    }
}
