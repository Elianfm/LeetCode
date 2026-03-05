import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    /*
     * First try, i use a list to store the levels of the tree, exploring in a depth first way,
     * but exploring the right node before the left node, this way i can be sure that the first 
     * node i find in a level is the right one. 
     * 
     * Runtime: 0ms beats 100%
     */
    class Solution {
        List<Integer> levels;

        public List<Integer> rightSideView(TreeNode root) {
            levels = new ArrayList<>();
            explore(root,0);
            return levels;
        }

        private void explore(TreeNode root, int level){
            if(root == null) return;

            if(levels.size() <= level) levels.add(root.val);
            explore(root.right, level+1);
            explore(root.left, level+1);
        }
    }

    public class TreeNode {
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
}
