class RecoverBST {

    /* 
     * First try, I got a problem because I was using the wrong pointers to
     * swap the nodes. But after some debugging I got the solution below.
     * 
     * Runtime: 1ms Beats 100%
     * Memory: 44.34MB Beats 86.46%
     */

     private TreeNode first = null;
     private TreeNode second = null;
     private TreeNode prev = null;
 
     public void recoverTree(TreeNode root) {
         inorder(root);
         int temp = first.val;
         first.val = second.val;
         second.val = temp;
     }
 
     private void inorder(TreeNode root) {
         if (root == null) return;
 
         inorder(root.left);
 
         if(prev == null) prev = root;
 
         if (first == null && prev.val > root.val) {
             first = prev;
         }
         
         if (first != null && prev.val > root.val) {
             second = root;
         }
 
         prev = root;
 
         inorder(root.right);
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
