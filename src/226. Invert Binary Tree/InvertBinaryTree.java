public class InvertBinaryTree {

    // Cleaner version
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return root; 

            TreeNode temp = root.left = invertTree(root.left);
            root.left = root.right = invertTree(root.right);
            root.right = temp;

            return root;
        }
    }

    // First try, DFS recursive approach
    // Runtime 0ms beats 100%
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null || root.left == null && root.right == null) return root; 

            if(root.left != null) root.left = invertTree(root.left);
            if(root.right != null) root.right = invertTree(root.right);

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            return root;
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
