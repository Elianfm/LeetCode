import java.util.ArrayDeque;

public class ReorderList {

    // pending try to do it in O(1) space and optimize runtime, with pointers

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
