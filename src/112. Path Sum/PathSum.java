class PathSum {
    /*
     * First try, DFS with recursion, using extra parameter to store the sum of the
     * path
     * Runtime: 0ms Beats 100%
     * Memory: 43.08MB Beats 76.11%
     */

    int target;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        return recursive(root, 0);
    }

    public boolean recursive(TreeNode root, int sum) {
        if (root == null) return false;
        sum += root.val;
        return (root.left == null && root.right == null && sum == target) ||
                recursive(root.left, sum) || recursive(root.right, sum);
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
