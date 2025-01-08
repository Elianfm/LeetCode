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
