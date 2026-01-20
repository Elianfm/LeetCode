public class SumAllSubsetXORTotals {

    /*
     * First try, recursive solution to explore all subsets and calculate the 
     * xor for each one possible.
     * Runtime: 0ms beats 100.00%
     */
    class Solution {
        public int subsetXORSum(int[] nums) {
            return subPos(nums, 0, 0);
        }

        public int subPos(int[] nums, int pos, int xorActual) {
            if (pos >= nums.length) return xorActual;

            return subPos(nums, pos + 1, xorActual) +
                    (subPos(nums, pos + 1, xorActual ^ nums[pos]));
        }

    }
}
