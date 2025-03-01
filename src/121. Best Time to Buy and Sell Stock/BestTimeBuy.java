public class BestTimeBuy {

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
