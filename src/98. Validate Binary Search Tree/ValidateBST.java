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

class ValidateBST {

    /*
     * First try, its a little tricky to get the logic right because the 
     * edge cases are not that obvious. I got a solution but it was not
     * clean (too many if statements). but after some refactoring I got the 
     * solution below.
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 43.86MB Beats 40.29%
     */

     private Integer prev = null;

     public boolean isValidBST(TreeNode root) {
         if (root == null) return true;
         if (!isValidBST(root.left)) return false;
 
         if (prev != null && prev >= root.val) return false;
         prev = root.val;
 
         return isValidBST(root.right);
     }

}
