import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    /*
     * First try, using HashSet to store the elements in the array.
     * 
     * Runtime 11ms beats 70.92%
     */

     class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> exist = new HashSet<>();
    
            for(int i = 0; i<nums.length; i++){
                int actual = nums[i];
                if(exist.contains(actual)) return true;
                exist.add(actual);
            }
            return false;
        }
    }
}
