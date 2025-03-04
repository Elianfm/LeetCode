public class ColorfulRope {
    /*
     * First try, two pointers with greedy approach
     * 
     * Runtime: 7ms Beats 90.39%
     * Memory: 60.80mb Beats 49.67%
     */
    class Solution {
        public int minCost(String colors, int[] neededTime) {
            char charPrev = '*';
            int numPrev = 0;
            int time = 0;
    
            for (int i = 0; i < colors.length(); i++) {
                char actual = colors.charAt(i);
    
                if( charPrev ==  actual ){
                    if(neededTime[numPrev] > neededTime[i]){
                        time += neededTime[i];
                    } else{
                        time += neededTime[numPrev];
                        numPrev = i;
                        charPrev = actual;
                    }
                }else{
                    numPrev = i;
                    charPrev = actual;
                }
            }
    
            return time;
        }
    }
}
