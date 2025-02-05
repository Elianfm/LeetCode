/* PENDING TO OPTIMIZE */
class RotateArray {


    /*
     * First try, i use recurse to solve this problem, but it's not efficient.
     * I go through the array storing every element in a temp variable and when
     * I reach the end of the array, I proceed to move the elements to the right
     * Runtime: 3ms Beats 8.59%
     * Memory: 65.41MB Beats 7.58%
     */

    /*
     * int len;
     * int[] nums;
     * 
     * public void rotate(int[] nums, int k) {
     * this.len = nums.length - 1;
     * this.nums = nums;
     * recurseRotate(k, 0);
     * }
     * 
     * public void recurseRotate(int k, int pos) {
     * if (pos == len + 1) return;
     * 
     * int actual = nums[pos];
     * int change = pos + k;
     * 
     * recurseRotate(k, pos + 1);
     * 
     * while (change > len) change -= (len + 1);
     * 
     * nums[change] = actual;
     * }
     */
}
