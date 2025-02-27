
/* PENDING */
public class ContainsDuplicates {

    /*
     * First try:
     * I tried to use two pointers in a sliding window to check if there are
     * duplicates in the window. But it is not efficient enough cause in the worst
     * case, the time complexity is O(n^2).
     * 
     * TLE
     */
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int left = 0;
            int right = 1;
            int num_right = nums[right];
            int checkNeg = num_right - valueDiff;
            int checkPos = valueDiff + num_right;

            while (right < nums.length) {
                if (left == right) {
                    if (++right == nums.length)
                        break;
                    num_right = nums[right];
                    checkNeg = num_right - valueDiff;
                    checkPos = valueDiff + num_right;

                    left = right - indexDiff;
                    if (left < 0)
                        left = 0;
                    continue;
                }

                int num_left = nums[left++];
                if (checkNeg <= num_left && num_left <= checkPos)
                    return true;
            }

            /*
             * |left-right| < v
             * -v < left-right < v
             * right-v < left < v-right
             */

            return false;
        }
    }

}
