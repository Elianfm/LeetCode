public class SingleNumber {
    /*
     * First try, after some thinking i wasn't able to find
     * a solution with linear and constant space complexity
     * at same time. After some time, i saw the hint about XOR 
     * bitwise operation, and then the solution was trivial.
     * 
     * Runtime 1ms beats 99.84%
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int searched = 0;

            for(int i = 0; i<nums.length; i++)
                searched ^= nums[i];

            return searched;
            
        }
    }
}
