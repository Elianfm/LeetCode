
public class SearchInsertPosition {
    /*
     * First try - it worked well
     * Runtime 0ms - Beats 100%
     * Memory 42.82mb - Beats 75.75%
     */

    public int searchInsert(int[] nums, int target) {
        return DAC(nums, target, 0, nums.length - 1);
    }

    public int DAC(int[] nums, int target, int left, int right) {
        if (left > right) return left;

        int mid = left + (right - left) / 2;

        return (target > nums[mid])
                ? DAC(nums, target, mid + 1, right)
                : DAC(nums, target, left, mid - 1);
    }
}
