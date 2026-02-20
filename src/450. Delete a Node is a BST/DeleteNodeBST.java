public class DeleteNodeBST {

    /*
     * Cleaner version of first try, i realize i can simplify the code by just checking if the right child is null, 
     * if it is i return the left child, if it is not i add the left child to the right child and return the right child.
     * the addNode method is simplified to addLeft, since we only need to add the left child to the right child, 
     * we just need to find the leftmost node of the right child and add the left child there.
     * 
     * Runtime 0ms beats 100%
     */
    class Solution2 {
        public TreeNode deleteNode(TreeNode root, int key) {
            return explore(root,key);
        }

        private TreeNode explore(TreeNode root, int key){
            if(root == null) return null;

            if(root.val == key){
                if(root.right == null) return root.left;
                if(root.left == null) return root.right;

                root.right = addLeft(root.right, root.left);
                return root.right;
                
            }

            if(root.val < key){
                root.right = explore(root.right, key);
            }else{
                root.left = explore(root.left, key);
            }

            return root;
        }

        private TreeNode addLeft(TreeNode root, TreeNode left){
            if(root == null) return left;
            root.left = addLeft(root.left, left);
            return root;
        }

    }

    /*
     * First try, i search the node to delete, i check if it has 0, 1 or 2 children, 
     * if it has 0 or 1 child i just return the child to the parent, if it has 2 children 
     * i add the left child to the right child and return the right child to the parent.
     * I use an addNode method to find the right place to add the left child to the right child.
     * 
     * Runtime 0ms beats 100%
     */
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            return explore(root,key);
        }

        private TreeNode explore(TreeNode root, int key){
            if(root == null) return null;

            if(root.val == key){
                if(root.right == null && root.left == null){
                    return null;
                }else if(root.right == null){
                    return root.left;
                } else{
                    if(root.left != null) root.right = addNode(root.right, root.left);
                    return root.right;
                }
            }

            if(root.val < key){
                root.right = explore(root.right, key);
            }else{
                root.left = explore(root.left, key);
            }

            return root;
        }

        private TreeNode addNode(TreeNode root, TreeNode newNode){
            if(root == null) return newNode;

            if(root.val < newNode.val){
                root.right = addNode(root.right, newNode);
            }else{
                root.left = addNode(root.left, newNode);
            }

            return root;
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
