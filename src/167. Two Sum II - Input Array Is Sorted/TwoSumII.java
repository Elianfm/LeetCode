public class TwoSumII {

    /*
     * First try, i use two pointers to find the two numbers that sum up to the
     * target.
     * If the sum is greater than the target, move the right pointer to the left.
     * (we need a smaller number)
     * If the sum is less than the target, move the left pointer to the right.
     * (we need a bigger number)
     * If the sum is equal to the target, return the indices of the two numbers.
     * 
     * Runtime: 2ms beats 92.59%
     * Memory: 47.07mb beats 79.13%
     */

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[left] + numbers[right];

                if (sum == target)
                    return new int[] { left + 1, right + 1 };

                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }

            return new int[] { 0, 0 };
        }
    }

}
