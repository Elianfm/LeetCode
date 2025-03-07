public class HouseRobber {
    /*
     * First try, using DP
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 40.93mb Beats 75.75%
     */

    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            int maxPrevious = nums[0];

            for (int i = 2; i < nums.length; i++) {
                nums[i] += maxPrevious;
                if (maxPrevious < nums[i - 1]) maxPrevious = nums[i - 1];
            }

            return Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        }
    }
}
