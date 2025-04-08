import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
     * Second try, after some wrong attempts, i used the two pointers method to
     * solve this problem.
     * 
     * The idea is to sort the array and then use two pointers to find the
     * complement of the first number. (Similar to the two sum problem)
     * 
     * Runtime: 28ms beats 79.31%
     * Memory: 51.50mb beats 71.76%
     */

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> out = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                int actual = nums[i];
                int target = -actual;

                if (i > 0 && nums[i] == nums[i - 1])
                    continue;

                while (left < right) {
                    int numLeft = nums[left];
                    int numRight = nums[right];
                    int sum = numLeft + numRight;

                    if (sum == target) {
                        Integer[] triplet = new Integer[] { numLeft, actual, numRight };
                        List<Integer> list = Arrays.asList(triplet);
                        out.add(list);
                        left++;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                    } else if (sum >= target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            return out;

        }
    }
}
