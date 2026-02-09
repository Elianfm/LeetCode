public class HouseRobberII{


    /*
     * First try, i first robbed the first house, so i can't rob the last one, 
     * then i robbed the second house, so i can't rob the first one, 
     * then i return the max of both cases.
     * 
     * Runtime: 0ms beats 100%
     */

    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 1) return nums[0];
            if(nums.length == 2) return Math.max(nums[0], nums[1]);

            int bestPrev = nums[0];
            int[] numsCopy = nums.clone();

            for(int i = 2; i<nums.length-1; i++){
                bestPrev = Math.max(nums[i-2], bestPrev);
                nums[i] += bestPrev;
            }

            int temp1 = Math.max(nums[nums.length-2], nums[nums.length-3]);
            nums = numsCopy;
            bestPrev = nums[1];

            for(int i = 3; i<nums.length; i++){
                bestPrev = Math.max(nums[i-2], bestPrev);
                nums[i] += bestPrev;
            }
            int temp2 = Math.max(nums[nums.length-1], nums[nums.length-2]);

            return Math.max(temp1, temp2);

        }
    }
}