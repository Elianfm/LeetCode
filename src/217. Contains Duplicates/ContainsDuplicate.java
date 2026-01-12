import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
     * Second try, in docs, hashset returns true or false when adding an element
     * according to whether the element already exists in the set, so we can use
     * that to simplify the code.
     * 
     * Runtime 10ms beats 99.19%
     */
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n))
                return true;
        }

        return false;
    }

    /*
     * First try, using HashSet to store the elements in the array.
     * 
     * Runtime 11ms beats 70.92%
     */

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> exist = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int actual = nums[i];
            if (exist.contains(actual))
                return true;
            exist.add(actual);
        }
        return false;
    }

}
