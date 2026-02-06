public class SortArray {


    // pending try with merge sort 
    // pending try with quick sort
    // pending try with heap sort

    /*
     * First try, insert sort, why not? brbrbrbr (intuitive)
     * Runtime TLE
     */
    class Solution {
        public int[] sortArray(int[] nums) {
            if(nums.length == 1) return nums;
            
            for(int i = 1; i<nums.length; i++){
                int idx = i;
                while(idx > 0){
                    int prev = nums[idx-1];
                    int actual = nums[idx];

                    if(prev < actual) break;

                    nums[idx-1] = actual;
                    nums[idx] = prev;
                    idx--;
                }
            }   

            return nums;
        }
    }
}
