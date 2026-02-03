import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

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
