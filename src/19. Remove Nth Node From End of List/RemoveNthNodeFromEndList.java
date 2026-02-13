public class RemoveNthNodeFromEndList {

    // Pending to try O(1n) instead of O(2n) solution

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
