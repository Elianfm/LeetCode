public class SubtreeOfAnotherTree {
    /*
    * First try, using doble recursion
    * First one to traverse the main tree and found the node that matches subRoot's root
    * Second one to check if both trees are the same from that node
    * Runtime 2ms beats 99.06%
    */
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null && subRoot == null) return true;
            if(root == null || subRoot == null) return false;

            if(root.val == subRoot.val)
                if(check(root, subRoot)) return true;
            
            return isSubtree(root.left, subRoot) 
                || isSubtree(root.right, subRoot);

        }

        private boolean check(TreeNode root, TreeNode subRoot){
            if(root == null && subRoot == null) return true;
            if(root == null || subRoot == null) return false;

            if(root.val != subRoot.val) return false;
            return check(root.right, subRoot.right) 
                && check(root.left, subRoot.left);
        }

    }
}