public class RemoveNthNodeFromEndList {

    /*
     * Second try, two pointers approach, one pointer is n steps ahead of the other, 
     * when the first pointer reaches the end, the second pointer will be at the target node
     * In my first try i had to double iterate the listnode, but in this approach we can do it in one pass
     * 
     * Runtime 0ms beats 100%
     */
    class Solution2 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            ListNode slow = head;

            while(n-- > 0)
                fast = fast.next;

            if(fast == null) return head.next;

            while(fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
            return head;
        }
    }

    /*
     * First try, after some tweaks i got this solution
     * 
     * Runtime 0ms beats 100%
     */
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            
            int size = 0;

            ListNode temp = head;
            while(temp != null){
                temp = temp.next;
                size++;
            }

            int target = size - n;

            if(size == 1) return null;
            if(target == 0) return head.next;

            temp = head;
            int pos = 1;

            while(temp != null){
                if(pos == target){
                    temp.next = temp.next.next;
                    break;
                }

                temp = temp.next;
                pos++;
            }

            return head;
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
