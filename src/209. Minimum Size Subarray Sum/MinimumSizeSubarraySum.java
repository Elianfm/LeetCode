/*
 * PENDING TO SOLVE IT IN O(n) TIME
 */
class MinimumSizeSubarraySum {

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
