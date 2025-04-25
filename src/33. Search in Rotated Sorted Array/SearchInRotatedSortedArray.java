// Pending to refactor the code
public class SearchInRotatedSortedArray {


    /*
     * First try, binary search with recursion.
     * Works good for all test cases, but the condition of the return 
     * statement is hardcoded and not easy to understand. So i need to
     * refactor it.
     * 
     * Runtime: 0ms beats 100%
     * Memory 42.24mb beats 40.08%
     */
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums,target, 0, nums.length-1);
        }

        private int binarySearch(int[] nums, int target, int left, int right){
            if(left > right) return -1;

            int mid = (left+right)/2;
            int midNum = nums[mid];

            if(midNum == target) return mid;

            int rightNum = nums[right];

            return (midNum > rightNum && (target <= rightNum || target > midNum)
                || midNum < rightNum && (target <= rightNum && target > midNum))
                ? binarySearch(nums, target, mid+1, right)
                : binarySearch(nums, target, left, mid-1);
        }
    }
}
