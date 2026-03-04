import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    /*
     * A few optimizations of first try
     * Runtime 6ms beats 97.88%
     */
    class Solution2 {
        List<List<Integer>> result;
        int right;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            this.result = new ArrayList<>();        
            this.right = nums.length;

            Arrays.sort(nums);

            for(int i = 0; i<nums.length - 3; i++){
                if(i > 0 && nums[i] == nums[i-1]) continue;
                threeSum(nums,target,i);
            }

            return result;
        }


        private void threeSum(int[] nums, int target, int left){
            int prev = nums[left];
            
            for(int i = left+1; i<right-2; i++){
                if(i > left+1 && nums[i] == nums[i-1]) continue;
                long minSum = (long) prev + nums[i] + nums[i+1] + nums[i+2];
                if(minSum > target) break;

                long maxSum = (long) prev + nums[i] + nums[right-1] + nums[right-2];
                if(maxSum < target) continue;

                int actualRight = right-1;
                int actualLeft = i+1;
                int actualNum = nums[i];

                while(actualLeft < actualRight){
                    long sums = (long) prev + actualNum + nums[actualLeft] + nums[actualRight];

                    if(sums == target){
                        List<Integer> actualLs = new ArrayList<>(Arrays.asList(
                            prev, actualNum, nums[actualLeft], nums[actualRight]));
                        result.add(actualLs);
                        actualLeft++;
                        actualRight--;

                        while (actualLeft < actualRight && nums[actualLeft] == nums[actualLeft - 1])
                            actualLeft++;
                        
                        while (actualLeft < actualRight && nums[actualRight] == nums[actualRight + 1])
                            actualRight--;
                        
                    }else if(sums < target){
                        actualLeft++;
                    }else{               
                        actualRight--;
                    }
                }

            }
        }
    }

    /*
     * First try, similar to 3sum problem, but i repeat 3sum for every number in the array, to find the 4 numbers that sum the target, 
     * i also need to sort the array to avoid duplicates and to use two pointers to find the 3 numbers that sum the target
     * 
     * Runtime 17ms beats 91.82%
     */
    class Solution {
        List<List<Integer>> result;
        int right;

        public List<List<Integer>> fourSum(int[] nums, int target) {
            this.result = new ArrayList<>();        
            this.right = nums.length;

            Arrays.sort(nums);

            for(int i = 0; i<nums.length - 3; i++){
                if(i > 0 && nums[i] == nums[i-1]) continue;
                threeSum(nums,target,i);
            }

            return result;
        }


        private void threeSum(int[] nums, int target, int left){
            int prev = nums[left];
            
            for(int i = left+1; i<right-1; i++){
                if(i > left+1 && nums[i] == nums[i-1]) continue;
                int actualRight = right-1;
                int actualLeft = i+1;
                int actualNum = nums[i];

                while(actualLeft < actualRight){
                    long sums = (long) prev + actualNum + nums[actualLeft] + nums[actualRight];

                    if(sums == target){
                        List<Integer> actualLs = new ArrayList<>(Arrays.asList(
                            prev, actualNum, nums[actualLeft], nums[actualRight]));
                        result.add(actualLs);
                        actualLeft++;
                        actualRight--;

                        while (actualLeft < actualRight && nums[actualLeft] == nums[actualLeft - 1])
                            actualLeft++;
                        
                        while (actualLeft < actualRight && nums[actualRight] == nums[actualRight + 1])
                            actualRight--;
                        
                    }else if(sums < target){
                        actualLeft++;
                    }else{               
                        actualRight--;
                    }
                }

            }
        }
    }
}
