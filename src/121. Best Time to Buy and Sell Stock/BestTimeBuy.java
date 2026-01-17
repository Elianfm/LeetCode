public class BestTimeBuy {

    /*
    * Using DP
    * Runtime 2ms beats 42.06%
    */
   class Solution2 {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int maxProfit = 0;

            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }

            return maxProfit;
        }

    }

    /*
     * First try, loop
     * Runtime 1ms beats 99.84%
     * Memory 61.72mb beats 50.71%
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int min = prices[0];
    
            for(int i = 1; i<prices.length; i++){
                int actual = prices[i];
                if(actual < min){
                    min = actual;
                } else{
                    maxProfit = Math.max(maxProfit, actual-min);
                }
            }
    
            return maxProfit;
        }
    }
}
