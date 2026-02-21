import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {


    /*
     * Looking another solutions, i realize i can simplify the code from first try 
     * by just exploring the combinations without the repeated number and then adding
     * it one by one until we reach the number of repetitions, also we can use target
     * instead of sum to check if we reached the target, this way we can avoid the sum 
     * variable and just use target - candidates[i] to check if we reached the target.
     * Pretty similar, but cleaner and faster.
     * 
     * Runtime 6ms beats 73.22%
     */
    class Solution2 {
        List<List<Integer>> sums = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            explore(candidates, target, 0);
            return sums;
        }

        private void explore(int[] candidates, int target, int pos){
            if(target == 0){
                sums.add(new ArrayList<>(ls));
                return;
            }

            for(int i = pos; i<candidates.length; i++){
                if(i > pos && candidates[i] == candidates[i-1]) continue;

                if(candidates[i] > target) break;

                ls.add(candidates[i]);
                explore(candidates, target - candidates[i], i + 1);
                ls.remove(ls.size() - 1);
            }

        }
    }

    /*
     * First try, sort the candidates and explore combinations, if we have a repeated number,
     *  we can explore the combinations without it and then add it one by one until we reach 
     * the number of repetitions, if we reach the target we add the combination to the result list.
     * 
     * Runtime 9ms beats 16.44%;
     */
    class Solution {
        List<List<Integer>> sums = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            explore(candidates, target, 0, 0, 0);
            return sums;
        }

        private void explore(int[] candidates, int target, int sum, int pos, int reps){
            if(pos >= candidates.length || sum > target) return;

            int actual = candidates[pos];

            if(pos < candidates.length -1 && candidates[pos+1] == actual){
                explore(candidates, target, sum, pos+1, reps+1);
                return;
            }

            explore(candidates, target, sum, pos+1,0);

            reps++;

            for(int i = 0; i<reps; i++){
                ls.add(actual);
                sum += actual;
                if(sum == target){
                    sums.add(new ArrayList(ls));
                }else if(sum < target){
                    explore(candidates,target,sum, pos+1, 0);
                }
            }

            for(int i = 0; i<reps; i++)
                ls.remove(ls.size() - 1);

        }
    }
}
