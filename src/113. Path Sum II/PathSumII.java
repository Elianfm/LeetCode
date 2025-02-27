import java.util.ArrayList;
import java.util.List;



class PathSumII {

    /*
     * Second try, after some refactoring, i realized i can just use one method
     * to solve the problem, and use a list to store the path, and backtracking
     * when the path is not valid, i cand just minus the last element of the list
     * until the path is valid (is equal to zero)
     * 
     * 
     */
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return paths;
        list.add(root.val);
        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0)
            paths.add(new ArrayList<>(list));

        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        list.remove(list.size() - 1);

        return paths;
    }

    /*
     * First try, i follow same approach as in PathSum I, but instead of returning
     * boolean, i just add the path to the paths list, using a list to store the
     * path and backtracking when the path is not valid.
     * Similar performance to the first try, but this one is more elegant and
     * easier to understand
     * 
     * Runtime: 1ms Beats 99.89%
     * Memory: 44.34MB Beats 91.36%
     */

    /*
     * 
     * int target;
     * List<List<Integer>> paths;
     * 
     * public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
     * this.target = targetSum;
     * paths = new ArrayList<>();
     * 
     * searchPath(root, 0, new ArrayList<>());
     * return paths;
     * }
     * 
     * private void searchPath(TreeNode root, int sum, List<Integer> list){
     * if(root == null) return;
     * 
     * sum += root.val;
     * list.add(root.val);
     * 
     * if(root.left == null && root.right == null){
     * if(sum == target) paths.add(new ArrayList<>(list));
     * } else{
     * searchPath(root.left, sum, list);
     * searchPath(root.right, sum, list);
     * }
     * list.remove(list.size()-1);
     * }
     * 
     */

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
