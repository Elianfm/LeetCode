public class ContainerWithMostWater {

    /*
     * Second try, i realized that we can avoid the multiplication every time we
     * change the left or right pointer if we move the pointer till we find a
     * bigger height.
     * 
     * Runtime: 2ms beats 98.88%
     */
     public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int actualLeft = height[left];
            int actualRight = height[right];

            int min = Math.min(actualLeft, actualRight);
            maxWater = Math.max(maxWater, min * (right - left));

            while (left < right && height[left] <= min) {
                left++;
            }

            while (left < right && height[right] <= min) {
                right--;
            }
        }

        return maxWater;
    }

    /*
     * After some failures, i tried two pointers approach.
     * The idea is to start with the two ends of the array and move towards the center.
     * We found the smallest height between the two pointers and move the pointer
     * that has the smallest height towards the center.
     * This is because the area is limited by the smallest height.
     * 
     * Runtime: 5ms beats 74.69%
     * Memory: 56.98mb beats 95.96%
     */
    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length-1;
            int maxWater = 0;
            
            while(left < right){
                int actualLeft = height[left];
                int actualRight = height[right];
                maxWater = Math.max(maxWater,Math.min(actualLeft, actualRight) * (right-left));
                
                if(actualLeft < actualRight) left++;
                else right--;
            }
    
            return maxWater;
        }
    }
}
