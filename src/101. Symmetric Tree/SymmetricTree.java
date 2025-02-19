class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SymmetricTree {
    /*
     * First try, at first i thought it was a good idea to use two recursive 
     * functions and a queue to check if the tree is symmetric or not. 
     * I didnt like this solution. So i tried this one below which is
     * much better.
     * Runtime: 0ms beats 100%
     * Memory: 41.93MB beats 40.07%
     */

     public boolean isSymmetric(TreeNode root) {
        return recurse(root.left, root.right);
    }

    private boolean recurse(TreeNode nleft, TreeNode nright){
        if (nleft == nright) return true;
        if (nleft == null || nright == null) return false;
        if (nleft.val != nright.val) return false;
        
        return recurse(nleft.left, nright.right) 
        && recurse(nleft.right, nright.left);
    }


}
