class removeDuplicatesFromSortedArray {

    /*
     * First try
     * Runtime 0ms beats 100%
     * Memory 45.02MB beats 21.64%
     */
    public int removeDuplicates(int[] nums) {
        int len = 1;

        for(int i = 1; i<nums.length; i++){
            if(nums[i] != nums[len-1]) nums[len++] = nums[i];
        }
        return len;
    }
}
