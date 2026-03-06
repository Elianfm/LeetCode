public class FindDuplicateNumber {

    // pending to try the solution in some over-complicated way like leetcode wants lol 

    /*
     * First real try, using two nested loops to find the duplicate number, it's really slow but it works.
     * O(n^2) time complexity, O(1) space complexity.
     * Runtime: TLE lol
     */
    class Solution2 {
        public int findDuplicate(int[] nums) {
            for(int i = 0; i<nums.length; i++){
                int actual = nums[i];
                for(int j = i+1; j<nums.length; j++){
                    if(actual == nums[j]) return nums[i];
                }
            }

            return 0;
        }
    }

    // I mean... O(100000) it's still O(1) constant extra space, lol
    // Runtime: 2ms beats 98.95%
    class Solution {
        public int findDuplicate(int[] nums) {
            boolean[] explored = new boolean[100000];

            for(int n: nums){
                if(explored[n-1]) return n;
                explored[n-1] = true;
            }

            return 0;
        }
    }
}
