public class ProductOfArray {
    /*
     * First try, using division and managing edge cases of zeros
     * 
     * Runtime: 2ms beats 87.94%
     */
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int[] res = new int[nums.length];
        int zeros = 0;

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(num == 0) zeros++; 
            mul *= (num == 0) ? 1 : nums[i];
        }

        if(zeros > 1) return new int[nums.length];

        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            int divisor = num;
            if(num == 0) divisor = 1;
            res[i] = (zeros > 0 && num != 0) ? 0: mul/divisor;

        }

        return res;
    }
}
