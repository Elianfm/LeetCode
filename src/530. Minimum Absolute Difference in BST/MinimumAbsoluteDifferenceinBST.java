


class MinimumAbsoluteDifferenceInBST {
    /*
     * THIRD TRY - I simplify the code from second try and got
     * a better solution (inOrder traversal)
     * Runtime 0ms Beats 100%
     * Memory 44.28MB Beats 84.36%
     */

    int difference = Integer.MAX_VALUE;
    int previous = -1;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return difference;
    }

    public void inOrder(TreeNode root) {
        if (root.left != null) inOrder(root.left);
        if (previous != -1) difference = Math.min(root.val - previous, difference);
        previous = root.val;
        if (root.right != null) inOrder(root.right);
    }

    /*
     * SECOND TRY - I was having a hard time to resolve the problem
     * so i try a brute force solution, and it worked
     * is pretty bad code, i just wanna show this because
     * it's the way i got to the best solution using inOrder traversal
     * after simplify the code.
     */

    /*
     * class Solution {
     * 
     * int difference = -1;
     * int previous = -1;
     * 
     * public int getMinimumDifference(TreeNode root) {
     * searchDifference(root);
     * System.gc();
     * return difference;
     * }
     * 
     * public int searchDifference(TreeNode root) {
     * if (root.left == null) {
     * if (previous == -1){
     * previous = root.val;
     * return (root.right == null) ? root.val :searchDifference(root.right);
     * } else if (root.right == null) {
     * int thisDiff = root.val - previous;
     * if (difference == -1) difference = thisDiff;
     * if (thisDiff < difference) difference = thisDiff;
     * return root.val;
     * } else {
     * int thisDiff = root.val - previous;
     * if (difference == -1) difference = thisDiff;
     * if (thisDiff < difference) difference = thisDiff;
     * previous = root.val;
     * return searchDifference(root.right);
     * }
     * } else {
     * previous = searchDifference(root.left);
     * }
     * 
     * int thisDiff = root.val - previous;
     * if (difference == -1) difference = thisDiff;
     * if (thisDiff < difference) difference = thisDiff;
     * previous = root.val;
     * return (root.right == null)
     * ? root.val
     * : searchDifference(root.right);
     * }
     * 
     * }
     */

    /*
     * FIRST TRY was failed
     * I just put it here to keep track of my learning curve
     * /
     * 
     * /* public int getMinimumDifference(TreeNode root) {
     * if (root.right == null && root.left == null) return 99999;
     * int difference = 0;
     * 
     * if(root.left == null){
     * difference = Math.min(
     * root.right.val - root.val,
     * getMinimumDifference(root.right)
     * );
     * } else if(root.right == null){
     * difference = Math.min(
     * root.val - root.left.val ,
     * getMinimumDifference(root.left)
     * );
     * } else{
     * difference = Math.min(
     * Math.min(
     * root.right.val - root.val,
     * getMinimumDifference(root.right)
     * ),
     * Math.min(
     * root.val - root.left.val,
     * getMinimumDifference(root.left)
     * ));
     * }
     * return difference;
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
