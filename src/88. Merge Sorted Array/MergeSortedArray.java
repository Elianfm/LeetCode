class MergeSortedArray {

    // similar
    // Runtime 0ms beats 100%
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            
            int pos = nums1.length-1;
            int posm = m-1;
            int posn = n-1;

            while (pos >= 0) {
                nums1[pos--] = 
                (posn < 0 || (posm >= 0 && nums1[posm] > nums2[posn]))
                ? nums1[posm--] : nums2[posn--];
            }
        }
    }

    // first
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (n > 0) {
            nums1[m + n - 1] = (m > 0 && nums1[m - 1] > nums2[n - 1]) ? nums1[--m] : nums2[--n];
        }
    }
}
