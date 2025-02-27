import java.util.Arrays;


public class SortedArrayToBST {

    /*
     * FIRST TRY - it worked
     * But there's a better way to do it using a Conquer and Divide approach
     * Will reimplement using this improved logic
     * Runtime 0ms Beats 100%
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        int mid = (len / 2);

        if (len == 0)
            return null;
        if (len == 1)
            return new TreeNode(nums[0]);

        TreeNode midTree = new TreeNode(nums[mid]);

        midTree.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));

        midTree.right = (len != 2)
                ? sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, len))
                : null;

        return midTree;
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
