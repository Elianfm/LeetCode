import java.util.HashMap;
import java.util.Map;

public class DiameterBinaryTree{

    /*
    * Third try, after some changes i got O(n) time complexity
    * Runtime 0ms beats 100%
    */
   class Solution2 {
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
    * I tried to improve first try using memoization to store depths
    * but still is inefficient
    * Runtime 4ms beats 15.09%
    */
   class Solution {

    Map<TreeNode, Integer> depthMemo = new HashMap<>();

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxDiameterLeft = diameterOfBinaryTree(root.left);
        int maxDiameterRight = diameterOfBinaryTree(root.right);

        int maxDiameter = Math.max(maxDiameterLeft, maxDiameterRight);

        int leftDepth = maxDeep(root.left);
        int rightDepth = maxDeep(root.right);

        int maxActual = leftDepth + rightDepth;

        return Math.max(maxActual, maxDiameter);
    }

    private int maxDeep(TreeNode root) {
        if (root == null) return 0;

        if (depthMemo.containsKey(root)) return depthMemo.get(root);
        
        int depth = 1 + Math.max(
            maxDeep(root.left),
            maxDeep(root.right)
        );

        depthMemo.put(root, depth);
        return depth;
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