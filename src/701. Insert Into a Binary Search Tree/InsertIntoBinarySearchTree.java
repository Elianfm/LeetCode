public class InsertIntoBinarySearchTree {

    /*
     * First try, at first i tried a inorder traversal to find the place to insert the new node
     * but thenn i realized this is a BST, so i can just compare the value to insert with the current 
     * node and decide if i need to go left or right, when is null i can insert the new node there
     * 
     * Runtime: 0ms beats 100%
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return (new TreeNode(val));

        if(val > root.val){
            root.right = insertIntoBST(root.right,val);
        } else { 
            root.left = insertIntoBST(root.left,val);
        }

        return root;
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
