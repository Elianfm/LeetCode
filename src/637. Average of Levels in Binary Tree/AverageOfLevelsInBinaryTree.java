class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/* IN PROCESS */
public class AverageOfLevelsInBinaryTree {

}

/*
 * FIRST TRY, i misundertood the question lol
 * my approach was to get the average of every binary subtree
 * in DFS way, but the question is asking for the average of
 * every complete level of the binary tree
 */

/*
 * public List<Double> averageOfLevels(TreeNode root) {
 * avgs.add((double) root.val);
 * recurse(root);
 * return avgs;
 * }
 * 
 * private void recurse(TreeNode root) {
 * if (root == null || (root.left == null && root.right == null))
 * return;
 * 
 * if (root.right == null) {
 * avgs.add((double) root.left.val);
 * } else if (root.left == null) {
 * avgs.add((double) root.right.val);
 * } else {
 * avgs.add((double) (root.left.val + root.right.val) / 2);
 * }
 * 
 * recurse(root.left);
 * recurse(root.right);
 * }
 */
