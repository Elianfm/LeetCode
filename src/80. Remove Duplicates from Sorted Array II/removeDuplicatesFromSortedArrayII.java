class removeDuplicatesFromSortedArrayII {
    /*
     * Second try, simpler and faster
     * Runtime 0ms beats 100%
     * Memory 44.62MB beats 43.39%
     */

    public int removeDuplicates(int[] nums) {
        int pos = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[pos - 1] == nums[i] && nums[pos - 2] == nums[i])
                continue;
            nums[pos++] = nums[i];
        }

        return pos;
    }

    /*
     * First try, similar to removeDuplicatesFromSortedArrayI
     * but is slow so i will try another approach
     * 1ms beats 18.73%
     * 44.68MB beats 43.39%
     */

    /*
     * public int removeDuplicates(int[] nums) {
     * int pos = 1;
     * boolean second = false;
     * 
     * for (int i = 1; i < nums.length; i++) {
     * if (nums[pos - 1] != nums[i]) {
     * nums[pos++] = nums[i];
     * second = false;
     * } else if (!second) {
     * nums[pos++] = nums[i];
     * second = true;
     * }
     * }
     * 
     * return pos;
     * }
     */
}
