import java.util.HashMap;
import java.util.Map;

public class MinCostClimbling {

    /*
     * Second try, using DP, storing in cost array the min accumulated cost to reach
     * that position, then return the min between the last two positions
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 43.15 Beats 61,73%
     */

     class Solution2 {
        public int minCostClimbingStairs(int[] cost) {
            for(int i = 2; i<cost.length; i++){
                cost[i] += Math.min(cost[i-1], cost[i-2]);
            }
    
            return Math.min(cost[cost.length-1],cost[cost.length-2]);
        }
    }

    /*
     * First try, overthinking the problem, i tried to use a recursive solution with
     * memoization 🥴
     * 
     * Runtime: 4ms Beats 2.37% (lol)
     * Memory: 44.67MB Beats 5.86% (double lol)
     */
    class Solution {

        int[] cost;
        int len;
        Map<Integer, Integer> memoization = new HashMap<>();
    
        public int minCostClimbingStairs(int[] cost) {
            this.cost = cost;
            this.len = cost.length;
            return Math.min(recursive(0), recursive(1));
        }
    
        private int recursive(int pos){
            if(pos >= len) return 0;
            if(memoization.containsKey(pos)) return memoization.get(pos);
            int actualCost = cost[pos] + Math.min(recursive(pos+1), recursive(pos+2));
            memoization.put(pos,actualCost);
            return actualCost;
        }
    }
}
