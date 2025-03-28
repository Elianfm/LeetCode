/* PENDING TRY to solve with O(n) complexity */
public class LongestConsecutiveSequence {

    /*
     * First try, approach with BRUTE FORCE, obviously i got TLE
     * so i just sorted the array and checked for consecutive numbers
     * but complexity is O(nlogn) because of sorting and the problem
     * asks for O(n) complexity
     * 
     * Runtime: 15ms beats 99.51%
     * Memory: 56.21mb beats 97.82%
     */

     class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums.length == 0) return 0;
            Arrays.sort(nums);
    
            int maxCount = 0;
            int actualCount = 1;
    
            int previous = nums[0];
            for(int i = 1; i<nums.length; i++){
                int actual = nums[i];
                if(actual == previous) continue;
                if(actual == previous+1){
                    actualCount++;
                }else{
                    maxCount = Math.max(maxCount, actualCount);
                    actualCount = 1;
                }
                previous = actual;
            }
    
            return Math.max(maxCount, actualCount);
        }
    }
}
