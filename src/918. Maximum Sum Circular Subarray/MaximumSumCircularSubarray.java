public class MaximumSumCircularSubarray {

    /*
     * First tried, at first i to explore two times the array till find the first
     * number of prev actual Sum (like a sliding window) but it didn't work, so i 
     * tried to to cut new actual sum at first negative number, but it also didn't work,
     * then realize that "negative number" could be a minimun sum subarray, so after some
     * time and help i got this solution, when i do Kadane's for find the max sum and min sum, 
     * then i compare the max sum with total sum - min sum, but if the max sum is negative, 
     * it means that all numbers are negative, so i return the max sum in that case.
     * 
     * Runtime 6ms beats 76.26%
     */
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            
            int maxAll = nums[0];
            int minAll = nums[0];
            int maxAct = nums[0];
            int minAct = nums[0];
            int totalSum = nums[0];

            for(int i = 1; i<nums.length; i++){
                int actual = nums[i];

                maxAct = Math.max(actual, maxAct + actual);
                minAct = Math.min(actual, minAct + actual);
                
                maxAll = Math.max(maxAct, maxAll);
                minAll = Math.min(minAct, minAll);

                totalSum += actual;
            }

            if (maxAll < 0) return maxAll;
            return Math.max(maxAll, totalSum - minAll);

        }
    }
}
