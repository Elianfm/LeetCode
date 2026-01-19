public class BalancedBinaryTree {
    /*
     *   First try, DFS + height calculation
     *   Runtime 0ms beats 100%
     */
    class Solution {

        boolean isValid = true;

        public boolean isBalanced(TreeNode root) {
            isBalancedHeight(root, 0);
            return isValid;
        }

        private int isBalancedHeight(TreeNode root, int height){
            if(root == null) return 0;
            
            int leftHeight = isBalancedHeight(root.left, height);
            int rightHeight = isBalancedHeight(root.right, height);

            int maxHeight = Math.max(leftHeight, rightHeight);

            if(Math.abs(leftHeight-rightHeight) > 1) isValid = false;

            return maxHeight + 1;

        }
    }

}