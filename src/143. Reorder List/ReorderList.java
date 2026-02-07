import java.util.ArrayDeque;

public class ReorderList {

    /*
     * Second try, i find the middle of the list, reverse the second half and then merge both lists.
     * 
     * Runtime 2ms beats 89.03%
     */
    class Solution2 {
        public void reorderList(ListNode head) {

            ListNode slow = head; 
            ListNode fast = head.next;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode reverse = reverse(slow.next);
            slow.next = null;

            ListNode first = head;


            while(reverse != null){
                ListNode nextFirst = first.next;
                ListNode nextReverse = reverse.next;
                first.next = reverse;
                reverse.next = nextFirst;

                first = nextFirst;
                reverse = nextReverse;
            }

        }


        private ListNode reverse(ListNode head){
            ListNode prev = null;
            ListNode next = head;

            while(next != null){
                ListNode temp = next.next;
                next.next = prev;
                prev = next;
                next = temp;
            }

            return prev;
        }
    }

    /*
     * First try, i thought i could use a ArrayDeque to store the nodes,
     * when is even i treat it like a stack, when is odd like a queue.
     * O(n) time, but its slow cause of the deque operations.
     * Runtime 4ms beats 12.63%
     */
    class Solution {
        public void reorderList(ListNode head) {
            ArrayDeque<ListNode> ad = new ArrayDeque<>();
            ListNode tempo = head.next;

            while(tempo != null){
                ad.offer(tempo);
                tempo = tempo.next;
            }


            ListNode previous = head;
            int size = ad.size();
            for(int i = 1; i<=size; i++){
                ListNode actual = (i % 2 == 0) 
                    ? ad.pop()
                    : ad.removeLast();

                previous.next = actual;
                previous = actual;
            }

            previous.next = null;

        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
