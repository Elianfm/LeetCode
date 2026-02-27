import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    /*
     * First try, i keep a index of the level where i am and i explore the tree in a depth first way, 
     * when i reach a new level i create a new list for that level and add the value of the node to
     * the list of that level.
     * 
     * Runtime 0ms beats 100%
     */
    class Solution {
        List<List<Integer>> ls = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            explore(root, 0);
            return ls;
        }

        private void explore(TreeNode root, int level){
            if(root == null) return;

            if(ls.size() -1 < level) ls.add(new ArrayList<>());
            
            List<Integer> actual =  ls.get(level);
            actual.add(root.val);

            explore(root.left, level+1);
            explore(root.right, level+1);
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
