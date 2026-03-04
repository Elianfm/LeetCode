public class AddTwoNumbers {

    /* 
     * Cleaner version of first try, using an int to store the carry and a dummy head to simplify the code.
     * Runtime: 1ms beats 99.82%
     */
    class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode actual = head;

            int carry = 0;

            while(l1 != null || l2 != null){            
                int val1 = (l1 == null) ? 0 : l1.val;
                int val2 = (l2 == null) ? 0 : l2.val;

                int sum = val1 + val2 + carry;
                carry = (sum > 9) ? 1 : 0;

                actual.next = new ListNode(sum%10);
                actual = actual.next;

                l1 = (l1 == null) ? null : l1.next;            
                l2 = (l2 == null) ? null : l2.next;   
            }

            if(carry == 1) actual.next = new ListNode(1);
            return head.next;

        }
    }


    /* 
     * First try, i go through the two lists and sum the values, if the sum is greater than 9, 
     * i set the carry to true and sum the next values with 1.
     * 
     * Runtime: 1ms beats 99.82%
     */
    class Solution {
        
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode actual = head;
            ListNode last = head.next;
            boolean carry = false;

            while(l1 != null || l2 != null){            
                int val1 = (l1 == null) ? 0 : l1.val;
                int val2 = (l2 == null) ? 0 : l2.val;

                int sum = val1 + val2;
                sum += (carry) ? 1 : 0;

                if(sum > 9){
                    carry = true;
                    sum %= 10;
                }else{
                    carry = false;
                }

                actual.val = sum;
                actual.next = new ListNode();
                last = actual;
                actual = actual.next;

                l1 = (l1 == null) ? null : l1.next;            
                l2 = (l2 == null) ? null : l2.next;   
            }

            if(carry){
                actual.val = 1;
            }else{
                last.next = null;
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
