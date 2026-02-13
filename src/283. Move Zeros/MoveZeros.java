public class MoveZeros {


    /*
     * Simple one pass solution, move all non-zero elements to left and fill the rest of the array with zeros 
     */
    class Solution2 {
        public void moveZeroes(int[] nums) {
            int leftIdx = 0;

            for(int i = 0; i<nums.length; i++){
                int actual = nums[i];
                if(actual != 0) nums[leftIdx++] = actual;
                if(i >= leftIdx) nums[i] = 0;
            }

        }
    }

    /*
     * First try, one pass to move all non-zero elements to left and count number of zeros
     * second pass to fill the rest of the array with zeros
     * 
     * Runtime 2ms beats 90.02%
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            int leftIdx = 0;
            int rightIdx = nums.length;

            for(int i = 0; i<nums.length; i++){
                int actual = nums[i];
                if(actual == 0){
                    rightIdx--;
                }else{
                    nums[leftIdx++] = actual;
                }
            }

            for(int i = rightIdx; i<nums.length; i++)
                nums[i] = 0;
            
        }
    }
}
