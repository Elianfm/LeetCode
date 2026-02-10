public class MaximumSubarray {

    /*
     * First try, after some failed attempts, i got this solution,
     * when the actual value is bigger than the sum of the actual value and the previous max,
     * this means that the previous max is not helping to get a bigger sum, so i start a new sum 
     * with the actual value, otherwise i keep adding to the previous max.
     * 
     * Runtime: 1ms beats 99.61%
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            int maxAll = nums[0];
            int max = nums[0];

            for(int i = 1; i<nums.length; i++){
                int actual = nums[i];
                max = Math.max(actual, max+actual);
                maxAll = Math.max(max, maxAll);
            }

            return maxAll;
        }
    }
}
