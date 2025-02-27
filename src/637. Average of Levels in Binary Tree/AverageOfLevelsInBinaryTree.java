import java.util.ArrayList;
import java.util.List;

/* PENDING try to solve it in a BFS way */
public class AverageOfLevelsInBinaryTree {
/*
 * SECOND TRY,  this time i solved it in a DFS way with recursion
 * RUNTIME 1ms, Beats 99.89% (2ms beats 95.89% with System.gc())
 * MEMORY 45.95mb, Beats 22.27% (44.12mb beats 100.00% with System.gc())
 */

    // first is sum, second is # of nodes
    List<long[]> preAvg = new ArrayList<>();
    int maxLevel = 0;

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgs = new ArrayList<>();
        recurse(root, 0);

        for (long[] sumAvg : preAvg) {
            avgs.add((double) sumAvg[0] / sumAvg[1]);
        }

        //System.gc(); 
        return avgs;
    }

    private void recurse(TreeNode root, int level) {
        if (root == null) return;
        if (level > maxLevel) maxLevel = level;

        if (level == preAvg.size()) {
            preAvg.add(new long[] { root.val, 1 });
        } else {
            preAvg.get(level)[0] += root.val;
            preAvg.get(level)[1] ++;
        }

        recurse(root.left, level + 1);
        recurse(root.right, level + 1);
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
