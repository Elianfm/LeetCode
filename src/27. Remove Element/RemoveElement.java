/*
* Alternative solution
*
* Runtime 0ms beats 100%
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int last = nums.length;

        int idx = 0;
        while (idx < last) {
            int actual = nums[idx++];
            if (actual != val) continue;
            
            nums[--idx] = nums[--last];
            nums[last] = actual;
        }

        return last;
    }
}



class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int pos = 0; pos < nums.length; pos++) {
            if (nums[pos] != val) {
                nums[count++] = nums[pos];
            }
        }

        return count;
    }
}
