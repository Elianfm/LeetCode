public class LowestCommonAncestorBST {

    // pending solve it with BST properties duh 

    /*
     * First try, after a headache, i solved it with a recursive approach,
     * dfs and counting, when i found a sum of 2 i set the node as the answer.
     * It works even if the tree is not a BST.
     * 
     * Runtime: 6ms beats 97.00%
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
