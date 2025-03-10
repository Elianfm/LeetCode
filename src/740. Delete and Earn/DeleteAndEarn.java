import java.util.Arrays;

public class DeleteAndEarn {

    /*
     * Second try, i realize that i can avoid sorting cuz i only need to know the
     * max number in the array
     * 
     * Runtime: 2ms beats 99.53%
     * Memory: 44.49mb 71.13%
     */

    class Solution2 {
        public int deleteAndEarn(int[] nums) {
            int max = 0;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            int[] dp = new int[max + 1];

            for (int i = 0; i < nums.length; i++) {
                int actual = nums[i];
                dp[actual] += actual;
            }

            int previousMax = 0;
            for (int i = 2; i <= max; i++) {
                previousMax = Math.max(previousMax, dp[i - 2]);
                dp[i] += previousMax;
            }

            return Math.max(dp[max], dp[max - 1]);
        }
    }

    /*
     * First try, i use sorting and DP
     * 
     * Runtime: 5ms beats 64.53%
     * Memory: 44.98mb beats 32.94%
     */

    class Solution {
        public int deleteAndEarn(int[] nums) {
            Arrays.sort(nums);

            int max = nums[nums.length - 1];
            int[] dp = new int[max + 1];

            for (int i = 0; i < nums.length; i++) {
                int actual = nums[i];
                dp[actual] += actual;
            }

            int previousMax = 0;
            for (int i = 2; i <= max; i++) {
                previousMax = Math.max(previousMax, dp[i - 2]);
                dp[i] += previousMax;
            }

            return Math.max(dp[max], dp[max - 1]);
        }
    }

}
