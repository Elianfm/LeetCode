public class ReverseLinkedList {
    class Solution {
        /*
         * First try, loop and create new nodes for the reversed list
         * Runtime: 0ms beats 100%
         */
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;
            ListNode prev = null;
            ListNode actual = head;

            while (actual != null) {
                ListNode newNode = new ListNode(actual.val, prev);
                prev = newNode;
                actual = actual.next;
            }

            return prev;
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
}