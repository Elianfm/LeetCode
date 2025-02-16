import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class InorderTraversal {
    /*
     * Second try, cleaner solution
     * Runtime: 0 ms Beats 100%
     * Memory: 41.70 MB Beats 64.20%
     */
    List<Integer> out = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return out;

        inorderTraversal(root.left);
        out.add(root.val);
        inorderTraversal(root.right);
        
        return out;
    }

    /*
     * First try, recursive solution
     * Runtime: 0 ms Beats 100%
     * Memory: 41.66MB Beats 64.20%
     */
    /*
     * 
     * List<Integer> out = new ArrayList<>();
     * 
     * public List<Integer> inorderTraversal(TreeNode root) {
     * if(root != null) this.recursive(root);
     * return out;
     * }
     * 
     * private void recursive(TreeNode root){
     * if(root.left == null && root.right == null){
     * out.add(root.val);
     * return;
     * }
     * 
     * if(root.left != null) inorderTraversal(root.left);
     * out.add(root.val);
     * if(root.right != null) inorderTraversal(root.right);
     * 
     * return;
     * }
     */
}
