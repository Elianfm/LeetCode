public class InsertGreatestCommonDivisorsLinkedList {

    /*
     * First try, previously i used euclidian algorithm in another problem,
     * so this time it was pretty intuitive to implement it in this problem, i just check
     * the actual node and the next node, then i create a new node with the value of the gcd
     * of the two nodes and i insert it between them, then i move to the next node and 
     * repeat the process until i reach the end of the list.
     * 
     * Runtime: 1ms beats 100%
     */
    class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            ListNode actual = head;

            while(actual.next != null){
                ListNode next = actual.next;
                ListNode newNode = new ListNode(euclidian(actual.val, next.val), next);
                actual.next = newNode;
                actual = next;
            }

            return head;
        }


        public int euclidian(int a, int b){
            return (a % b == 0) ? b : euclidian(b, a%b);
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
