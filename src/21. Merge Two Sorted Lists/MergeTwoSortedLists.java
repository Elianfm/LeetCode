public class MergeTwoSortedLists {

    /*
     * First try, i make a merged ListNode and loop through both lists
     * Runtime: 0ms beats 100%
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode merged = null;
            ListNode head = null;

            while (list1 != null || list2 != null) {
                ListNode newNode = null;
                if (list1 == null || list2 != null && list1.val > list2.val) {
                    newNode = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    newNode = new ListNode(list1.val);
                    list1 = list1.next;
                }

                if (merged == null) {
                    head = newNode;
                } else {
                    merged.next = newNode;
                }
                
                merged = newNode;
                

            }

            return head;
        }
    }
}
