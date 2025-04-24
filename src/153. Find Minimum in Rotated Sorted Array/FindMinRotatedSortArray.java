// PENDING TO REFACTOR
public class FindMinRotatedSortArray {
    /*
     * First try, i use binary search to find the minimum number in the rotated sorted array.
     * The idea is to find the mid number and check if the next number is smaller than the mid number.
     * If it is, then the next number is the minimum number. If not, then check if the mid number is 
     * greater than the previous number. This means that the minimum number is in the right half of the array.
     * 
     * It works and its O(log n), but i think the code can be improved.
     * 
     * Runtime: 0ms beats 100%
     * Memory: 42.28mb beats 31.63%
     */
    class Solution {
        public int findMin(int[] nums) {
            if(nums.length == 1) return nums[0];
            if(nums.length == 2) return Math.min(nums[0],nums[1]);
    
            return binarySearch(nums, 0, nums.length-1, nums[0]);
        }
    
        private int binarySearch(int[] nums, int left, int right, int prev){
            int mid = (left + right)/2;
            int next = (mid+1 == nums.length) ? 0 : mid+1;
            int midNum = nums[mid];
            int nextNum = nums[next];
    
            if(nextNum < midNum) return nextNum;
    
            return (midNum > prev)
                ? binarySearch(nums, mid+1, right, midNum)   
                : binarySearch(nums, left, mid-1, midNum);
        }
    }
}
