import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ContainsNearbyDuplicates {
    /*
     * Second try, instead of using a hashmap, i can use a set to store the
     * elements, and check if the set contains the element, if it does, return true,
     * otherwise, add the element to the set, and if the set size is greater than k,
     * remove the element at index i - k. (sliding window)
     * 
     * Runtime: 19ms Beats 54.66%
     * Memory: 54.92 Beats 97.21%
     */

    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                int actual = nums[i];

                if (set.contains(actual))
                    return true;

                set.add(actual);

                if (i >= k)
                    set.remove(nums[i - k]);
            }

            return false;

        }
    }

    /*
     * First try, i use a hashmap to store the index of the element, and check if
     * the difference between the current index and the previous index is less than
     * or equal to k, if it is, return true, otherwise, update the index of the
     * element
     * 
     * Runtime: 19ms Beats 54.66%
     * Memory: 57.75 Beats 58.48%
     */

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> prev = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (prev.containsKey(num) && (Math.abs(prev.get(num) - i) <= k)) {
                return true;
            }

            prev.put(num, i);
        }

        return false;

    }
}
