public class SortColors {

    /*
     * First try, i use 3 pointers, one for the red color, one for the blue color and one to explore the array,
     * if i find a red color, i swap it with the red pointer and move both pointers, if i find a blue color, 
     * i swap it with the blue pointer and move only the blue pointer, this to avoid to swap a blue color with a same
     * blue color, if i find a white color, i just move the exploring pointer.
     * 
     * Runtime: 0ms beats 100%
     */
    class Solution {
        public void sortColors(int[] nums) {
            int redIdx = 0;
            int blueIdx = nums.length - 1;
            int posIdx = 0;

            while(posIdx <= blueIdx){
                int actual = nums[posIdx];

                if(actual == 0){
                    int temp = nums[redIdx];
                    nums[redIdx++] = actual;
                    nums[posIdx] = temp;
                    posIdx++;
                }else if(actual == 1){
                    posIdx++;
                }else{
                    int temp = nums[blueIdx];
                    nums[blueIdx--] = actual;
                    nums[posIdx] = temp;
                }
            }

        }
    }
}
