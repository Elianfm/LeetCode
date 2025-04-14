public class BinarySearch {

    /*
     * First try, using binary search to find the target in the array.
     * I used a recursive function to do the binary search, with two
     * pointers, left and right, to find the target.
     * 
     * Runtime: 0ms beats 100%
     * Memory: 45.44mb beats 95.75% 
     */

     class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, 0, nums.length-1, target);
        }
    
        private int binarySearch(int[] nums, int left, int right, int target){
            //if(left == right && nums[left] != target) return -1;
            if(left > right) return -1; // slightly better than the above line
    
            int mid = (left + right)/2;
            int numMid = nums[mid];
    
            if(numMid == target) return mid;
    
            return (target < numMid) 
                ? binarySearch(nums, left, mid-1, target)
                : binarySearch(nums, mid+1, right, target);
    
        }
    }
}
