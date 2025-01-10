class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}

public class LinkedListCycle {
    /*
     * THIRD TRY, i found there is a better solution
     * using Floyd's Cycle Detection Algorithm, this is an algorithm
     * that uses two pointers, one slow and one fast, if there is a cycle
     * the two pointers will meet at some point.
     * Runtime 0ms beats 100%
     * with System.gc() uncommented, the memory usage is 43.40 beats 99.77%
     * but it will have a worse performance (1ms), so i commented it.
     */

    public boolean hasCycle(ListNode head) {
        ListNode slower = head, faster = head;

        while (faster != null && faster.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (faster == slower) {
                // System.gc();
                return true;
            }
        }
        // System.gc();

        return false;
    }

    /*
     * SECOND TRY, i thought avoid hashset would improve performance,
     * so i use a listnode flag to mark visited nodes, from O(n) to O(1)
     * Runtime 1ms beats 20.45%
     * Memory 44.35 beats 70.60%
     * 
     * public boolean hasCycle(ListNode head) {
     * ListNode visited = new ListNode(0);
     * ListNode current = head;
     * ListNode flag;
     * 
     * if(current == null) return false;
     * while(current != null){
     * if(current.next == visited) return true;
     * flag = current.next;
     * current.next = visited;
     * current = flag;
     * }
     * 
     * return false;
     * }
     * 
     */

    /*
     * FIRST TRY, POOR PERFORMANCE
     * Runtime 5ms beats 9.49%
     * Memory 45.23 beats 6.26%
     *
     * public boolean hasCycle(ListNode head) {
     * Set<ListNode> nodes = new HashSet<>();
     * ListNode current = head;
     * 
     * if(current == null) return false;
     * while(current.next != null){
     * nodes.add(current);
     * if(nodes.contains(current.next)) return true;
     * current = current.next;
     * }
     * 
     * return false;
     * 
     */
}
