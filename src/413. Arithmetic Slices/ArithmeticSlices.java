public class ArithmeticSlices {

    /*
     * First try: Sliding window with triangular number
     * Runtime: 100 ms Beats 100%
     * Memory: 41.05MB Beats 98.07%
     */
    class Solution {
        /*
         * 123456
         * 12345 23456
         * 1234 2345 3456
         * 123 234 345 456
         */
    
        // 3 = +1; 4 = +3; 5 += 6; 6 += 10; [1]1-[2]3-[3]6-[4]10
        // n = count-2; n(n+1)/2
        // (n-2)(n-1)/2
    
        public int numberOfArithmeticSlices(int[] nums) {
            if(nums.length <= 1) return 0;
            
            int slices = 0;
            int left = 0;
            Integer difference = null;
            int count = 0;
    
            while (left < nums.length-1) {
                int actualDiff = nums[left+1] - nums[left++];
                if (difference == null || actualDiff != difference) {
                    slices += slices(count);
                    difference = actualDiff;
                    count = 2;
                }else{
                    count++;
                }
            }
            
            return slices + slices(count);
        }
    
        private int slices(int count){
            return (count > 2) ? ((count-2) * (count -1)) / 2 : 0;
        }
    }
}
