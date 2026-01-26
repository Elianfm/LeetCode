public class LowestCommonAncestor {

    /*
     * First try, i solved it 235 without considering the BST properties,
     * but it works here as well. so.
     * 
     * Runtime: 7ms beats 98.86%
     */
    class Solution {
        TreeNode node = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            lwa(root, p, q);
            return node;
        }

        private int lwa(TreeNode root, TreeNode p, TreeNode q){
            if(root == null) return 0;

            int left = lwa(root.left, p, q);
            int right = lwa(root.right,p,q);
            int res = left + right;

            if(root == p || root == q) res++;
            if(res == 2 && node == null) node = root;
            return res;

        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}