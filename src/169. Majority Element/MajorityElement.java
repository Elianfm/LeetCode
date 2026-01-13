import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* PENDING TO OPTIMIZE */
class MajorityElement {

    /*
    * Third try, after some tries and research, i got a Boyer-Moore Voting Algorithm
    * Its pretty simple; we keep a count that is incremented when we find the same element
    * and decremented when we find a different one. When the count reaches zero, we change
    * the candidate to the current element. At the end, the candidate is the majority element.
    * 
    * Runtime: 1ms beats 99.82%
    */
   class Solution2 {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;

            for(int i = 0; i<nums.length; i++){
                if(count == 0) candidate = nums[i];
                count += (candidate == nums[i]) ? 1: -1;
            }

            return candidate;
        }

    }



    /*
     * Second try, simple but complexity is O(n log n) because of sorting
     *
     * Runtime: 6ms beats 49.92%
     */
    class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }
    }

    /*
     * First try, this time i tried a queue for
     * storing the elements and removing if found
     * another element that is not the same
     * 
     * Runtime: 8ms Beats 30.07%
     * Memory: 50.7MB Beats 70.32%
     */

    public int majorityElement(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        for (int n : nums) {
            if (queue.peek() == null) {
                queue.offer(n);
                continue;
            }

            if (queue.peek() == n) {
                queue.offer(n);
            } else {
                queue.remove();
            }
        }

        return queue.peek();
    }

}
