public class MaximumDepthOfBinaryTree {
    /* SECOND TRY, i found there is a better solution
     * without using the count variable, just return the maximum
     * of the left and right subtree, and add 1 to the result.
     * this allows using just one recursive function.
     * 
     */

     public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int right = maxDepth(root.right)+1;
        int left = maxDepth(root.left)+1;
        
        return (right > left) ? right : left;
    }



    /*
     * FIRST TRY, my first thought was to use a recursive approach to
     * traverse the tree, and return the maximum depth of the tree,
     * surprisingly, it was a first try success.
     * 
     * Runtime 0ms beats 100%
     * Memory 42.48 beats 81.19%
     */

    /*
     * public int maxDepth(TreeNode root) {
     * if(root == null) return 0;
     * return depthRec(root, 1);
     * }
     * 
     * public int depthRec(TreeNode root, int count){
     * if(root.left == null && root.right == null) return count;
     * if(root.left == null) return depthRec(root.right, count+1);
     * if(root.right == null) return depthRec(root.left, count+1);
     * 
     * int right = depthRec(root.right, count+1);
     * int left = depthRec(root.left, count+1);
     * return (right > left) ? right : left;
     * }
     */

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
