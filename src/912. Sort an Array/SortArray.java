public class SortArray {


    /*
     * Second try, merge sort, i divide the array in two till i have arrays of size 1
     * then i merge them with two pointers one for each array and repeat
     * 
     * Runtime 25ms beats 69.15%
     */

    class Solution2 {
        public int[] sortArray(int[] nums) {
            return merge(nums, 0, nums.length-1);
        }

        private int[] merge(int[] nums, int left, int right){
            if(left == right) return (new int[]{nums[left]});

            int mid = (left+right)/2;

            int[] l = merge(nums, left, mid);
            int[] r = merge(nums,mid+1, right);

            int[] res = new int[l.length + r.length];

            int posL = 0;
            int posR = 0;
            int posRes = 0;

            while(posRes < res.length){
                res[posRes++] = 
                    ((posL == l.length) || (posR < r.length && r[posR] < l[posL])) 
                    ? r[posR++]
                    : l[posL++];
            }

            return res;
        }
    }

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
