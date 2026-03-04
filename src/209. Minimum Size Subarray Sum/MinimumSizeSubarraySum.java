
class MinimumSizeSubarraySum {

    /*
     * Cleaner version of second try, i dont need two loops to find the minimum size of the subarray that sums up to target,
     * 
     * Runtime 1ms beats 99.77%
     */
    class Solution2 {
        public int minSubArrayLen(int target, int[] nums) {
            int minCount = Integer.MAX_VALUE;
            int actualSum = 0;
            int rightIdx = 0;
            int leftIdx = 0;
            
            while(rightIdx < nums.length){
                actualSum += nums[rightIdx++];
                while(actualSum >= target){
                    minCount = Math.min(minCount, rightIdx-leftIdx);
                    actualSum -= nums[leftIdx++];            
                }
            }

            return (minCount == Integer.MAX_VALUE) ? 0 : minCount;

        }
    }

    /*
     * Second try, using sliding window, two pointers and a while loop to find the minimum 
     * size of the subarray that sums up to target.
     * 
     * Runtime: 1ms beats 99.77%
     */
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int minCount = 0;
            int actualSum = 0;
            int rightIdx = 0;
            int leftIdx = 0;
            
            while(rightIdx < nums.length && actualSum < target){
                actualSum += nums[rightIdx];
                rightIdx++;
            }

            if(actualSum < target) return 0;

            minCount = rightIdx;
            while(true){
                while(actualSum >= target){
                    actualSum -= nums[leftIdx++];            
                    minCount = Math.min(minCount, rightIdx-leftIdx+1);
                }
                if(rightIdx >= nums.length) break;
                actualSum += nums[rightIdx++];
            }

            return minCount;

        }
    }


    /*
     * First try, I solve it but it's extremely slow 
     * because of the nested loop O(n^2)
     * Runtime: 1867 ms Beats 5.07%
     * Memory: 58.46ms Beats 19.79%
     */

    /*
     * public int minSubArrayLen(int target, int[] nums) {
     * 
     * int pos_a = 0;
     * int pos_b = Integer.MAX_VALUE;
     * int sum = 0;
     * 
     * for(int i = 0; i<nums.length; i++){
     * sum += nums[i];
     * 
     * if(sum + nums[i] >= target){
     * int new_sum = 0;
     * for(int j=i; j>=0; j--){
     * new_sum += nums[j];
     * if(j < pos_a) break; // i added this line but its still slow 1423ms
     * if(new_sum < target) continue;
     * 
     * 
     * if(new_sum <= sum && pos_b-pos_a > i-j){
     * pos_a = j;
     * pos_b = i;
     * sum = new_sum;
     * } else{
     * break;
     * }
     * }
     * }
     * 
     * 
     * }
     * 
     * return (sum>=target) ? (pos_b - pos_a) + 1: 0;
     * }
     */
}
