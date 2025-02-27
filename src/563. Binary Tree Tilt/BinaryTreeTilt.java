class BinaryTreeTilt {
    /*
     * First try using DFS and a extra variable to store the tilt
     * Runtime: 0ms Beats 100%
     * Memory: 44.56MB Beats 34.37%
     */

     private int sum;

     public int findTilt(TreeNode root) {
         recursive(root);
         //System.gc(); runtime 1ms Beats 20.40% memory 42.75MB Beats 100%
         return sum;
     }
 
     private int recursive(TreeNode root){
         if(root == null) return 0;
 
         int left = recursive(root.left);
         int right = recursive(root.right);
 
         sum+= Math.abs(left-right);
         return root.val+left+right;
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
