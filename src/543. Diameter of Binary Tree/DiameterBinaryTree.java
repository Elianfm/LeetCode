public class DiameterBinaryTree{

    /*
    * Second try, after some changes i got O(n) time complexity
    * Runtime 0ms beats 100%
    */
   class Solution {
        private int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return diameter;
        }

        private int depth(TreeNode root) {
            if (root == null) return 0;

            int left = depth(root.left);
            int right = depth(root.right);

            diameter = Math.max(diameter, left + right);

            return 1 + Math.max(left, right);
        }
    }



    /*
    * First try, DFS, O(n^2) time complexity
    * Runtime 181ms beats 11.64%
    */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int maxDiameterLeft = diameterOfBinaryTree(root.left);
        int maxDiameterRight = diameterOfBinaryTree(root.right);

        int maxDiameter = Math.max(maxDiameterLeft, maxDiameterRight);
        int maxActual = maxDeep(root.left) + maxDeep(root.right);

        return Math.max(maxActual,maxDiameter);
    }

    private int maxDeep(TreeNode root){
        if(root == null) return 0;

        int maxLenLeft = maxDeep(root.left);
        int maxLenRight = maxDeep(root.right);

        return 1 + Math.max(maxLenLeft, maxLenRight);
    }

}