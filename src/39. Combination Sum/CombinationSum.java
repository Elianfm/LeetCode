import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    /*
     * Second try, similar approach, i add the ls directly in the while and then i remove it after the while,
     * this way i avoid to do a lot of backtracking when the sum exceed the target.
     * 
     * Runtime: 2ms beats 95.13%
     */
    class Solution2 {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            explore(candidates, target, 0, 0);
            return res;
        }

        private void explore(int[] candidates, int target, int sum, int pos){
            if(pos >= candidates.length) return;

            int actual = candidates[pos];
            int count = 0;

            while(sum < target){
                explore(candidates, target, sum, pos+1);
                ls.add(actual);
                sum += actual;
                count++;

                if(sum == target) res.add(new ArrayList<Integer>(ls));
            }

            while(count-- > 0)
                ls.remove(ls.size()-1);
        }
    }

    /*
     * First try, i use backtracking, two paths: one where I take the number
     * and another where I don't take it. I use a while to keep taking the same number
     * until the sum exceed the target.
     * 
     * Runtime: 4ms beats 17.51%
     */
    class Solution {
        List<List<Integer>> myList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            explore(candidates, target, 0, 0);
            return myList;
        }

        private void explore(int[] candidates, int target, int pos, int sum){
            if(sum == target){
                myList.add(new ArrayList<Integer>(current));
                return;
            }
            
            if(sum > target || pos >= candidates.length) return;

            int actual = candidates[pos];
            int count = 0;

            while(sum <= target){
                explore(candidates, target, pos+1, sum);
                current.add(actual);
                sum += actual;
                count++;
            }

            while(count-- > 0) current.remove((Integer) actual);
        }

    }
}
