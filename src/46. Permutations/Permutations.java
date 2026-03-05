public class Permutations {

    /*
     * Second try, i thought i could add to the ls every possible number, in the
     * next recursive call i do the same except the numbers that are already in the ls, 
     * At first i thought to use ls.contains but maybe it was too slow, so i thought i 
     * could just swap the actual position with the position of the number i want to add, 
     * this way i can be sure that the number is not in the ls, and when finish i swap back, 
     * this way i can be sure that the original array is not modified, and i can explore all 
     * the possible combinations without ls.contains() every time
     * 
     * Runtime: 1ms beats 85.63%
     */
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            explore(nums,0);
            return result;
        }

        private void explore(int[] nums, int pos){
            if(pos == nums.length){
                result.add(new ArrayList<>(ls));
                return;
            }

            for(int i = pos; i<nums.length;i++){
                ls.add(nums[i]);
                swap(nums,pos,i);

                explore(nums, pos+1);

                ls.remove(ls.size()-1);
                swap(nums,pos,i);
            }
        }

        private void swap(int[] nums, int pos, int i){
            int temp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = temp;
        }

    }


    /* First try, i tried first exploring everything in backtracking way, two ways
     * First no taking the actual number, or taking the actual number, reset the 
     * position and keep a boolean[] explored to indicate if the number is already 
     * in the actual permutation, it works but i thought it was inefficient, cause
     * i have to explore the same number multiple times, so i tried another way, 
     * see second try
     */
}
