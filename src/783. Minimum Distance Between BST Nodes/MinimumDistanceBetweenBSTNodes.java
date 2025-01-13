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

/* SAME AS 530. Minimum Absolute Difference in BST
* Runtime 0 ms - beats 100.00%
* Memory 41.32 MB - beats 48.16%
*/
class MinimumDistanceBetweenBSTNodes {

    int difference = Integer.MAX_VALUE;
    int previous = -1;

    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return difference;
    }

    public void inOrder(TreeNode root) {
        if (root.left != null) inOrder(root.left);
        if (previous != -1) difference = Math.min(root.val - previous, difference);
        previous = root.val;
        if (root.right != null) inOrder(root.right);
    }
}
