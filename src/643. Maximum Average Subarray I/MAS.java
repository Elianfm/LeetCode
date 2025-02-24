class MAS {
    /*
     * First try, using a sliding window to find the maximum average
     * At first i was using unoptimized sliding window, after some retouching
     * i got the below solution
     * 
     * Runtime: 4ms Beats 61.75%
     * Memory: 56.86 Beats 12.79%
     */

    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }

            double maxSum = sum;

            for (int right = k; right < nums.length; right++) {
                sum += nums[right] - nums[right - k];
                maxSum = Math.max(maxSum, sum);
            }

            return maxSum / k;
        }
    }
}
