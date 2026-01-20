public class BalancedBinaryTree {
    /*
     *   First try, DFS + height calculation
     *   Runtime 0ms beats 100%
     */
    class Solution {

        boolean isValid = true;

        public boolean isBalanced(TreeNode root) {
            isBalancedHeight(root);
            return isValid;
        }

        private int isBalancedHeight(TreeNode root){
            if(root == null) return 0;
            
            int leftHeight = isBalancedHeight(root.left);
            int rightHeight = isBalancedHeight(root.right);

            int maxHeight = Math.max(leftHeight, rightHeight);

            if(Math.abs(leftHeight-rightHeight) > 1) isValid = false;

            return maxHeight + 1;

        }
    }

    public class TreeNode {
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