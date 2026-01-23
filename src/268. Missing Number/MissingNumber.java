public class MissingNumber{

    /*
     * Alr, i got the bit manipulation approach
     * runtime 0ms beats 100%
     */
    class Solution2 {
        public int missingNumber(int[] nums) {
            int miss = nums.length;
            for(int i = 0; i<nums.length; i++)
                miss ^= i^nums[i];

            return miss;
        }
    }

    /*
     * First try, after some tries to solve this with bit manipulation i 
     * got the math approach. (???)
     * 
     * Runtime 0ms beats 100%
     */
    class Solution {
        public int missingNumber(int[] nums) {
            int miss = 0;
            int len = nums.length;
            int sum = (len * (len + 1))/2;

            for(int i = 0; i<len; i++)
                miss += nums[i];

            return sum-miss;
        }
    }

}