import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
     * Same logic, but avoids creating new lists all the time,
     * in this way we avoid the overhead of creating new lists.
     */
    class Solution2 {
        List<List<Integer>> list = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            recursive(nums, new ArrayList<>(), 0);
            return list;
        }

        private void recursive(int[] nums, List<Integer> ls, int pos){
            if(pos == nums.length){
                list.add(new ArrayList<>(ls));
                return;
            }
            
            recursive(nums, ls, pos+1);

            ls.add(nums[pos]);
            recursive(nums,ls,pos+1);
            
            ls.remove(ls.size() - 1); 
        }
    }

    /*
     * First try, recursive, i go over all elements and i have two choices,
     * add it to the current subset or not. when i reach the end, i add the current
     * subset to the list.
     * 
     * Runtime 1ms beats 88.05%
     */
    class Solution {
        List<List<Integer>> list = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            recursive(nums, new ArrayList<>(), 0);
            return list;
        }

        private void recursive(int[] nums, List<Integer> ls, int pos){
            if(pos == nums.length){
                list.add(ls);
                return;
            }
            
            recursive(nums, ls, pos+1);

            List<Integer> newList = new ArrayList<>(ls);
            newList.add(nums[pos]);
            recursive(nums,newList,pos+1);
        }
    }
}
