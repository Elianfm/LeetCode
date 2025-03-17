import java.util.Map;

public class TwoSum {
    /*
     * First try, i thought on using a O(n^2) solution, but i saw the follow up then i
     * decided to tried a O(n) solution. So i used a HashMap for this.
     * 
     * Runtime 2ms beats 98.83%
     */

     class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            
            for(int i = 0; i<nums.length; i++){
                int actual = nums[i];
                if(map.containsKey(actual)) return new int[] {i, map.get(actual)};
                map.put(target-actual,i);
            }
    
            return new int[2];
        }
    }
}
