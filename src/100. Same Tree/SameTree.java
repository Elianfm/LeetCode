import java.util.LinkedList;
import java.util.Queue;


class SameTree {
    /*
     * Second try, using BFS
     * I tried using recursion with BFS but it wasn't concise
     * So i used a loop instead
     * Runtime: 0ms Beats 100%
     * Memory: 41.20MB Beats 52.31%
     */
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue_p = new LinkedList<>();
        Queue<TreeNode> queue_q = new LinkedList<>();

        queue_p.add(p);
        queue_q.add(q);

        while(!queue_p.isEmpty() && !queue_q.isEmpty()){
            TreeNode node_p = queue_p.poll();
            TreeNode node_q = queue_q.poll();

            if(node_p == null && node_q == null) continue;
            if(node_p == null || node_q == null || node_p.val != node_q.val) return false;

            queue_p.add(node_p.left);
            queue_q.add(node_q.left);
            queue_p.add(node_p.right);
            queue_q.add(node_q.right);
        }


        return true;
    }

    
    /*
     * First try, using recursion and DFS
     * Runtime: 0ms Beats 100%
     * Memory: 41.11MB Beats 52.32%
     */

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
