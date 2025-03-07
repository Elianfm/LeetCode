import java.util.HashMap;
import java.util.Map;

class LongestHarmonious {

    /*
     * Pending try to solve it using sliding window
     */



    /* 
     * First try, using a hashmap to store the frequency of the elements, then
     * iterate over the keys
     * 
     */

     
    public int findLHS(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        int max = 0;

        for(int num: nums){
            count.merge(num,1,Integer::sum);
        }

        for(int num: count.keySet()){
            if(count.containsKey(num+1)){
                max = Math.max(max, count.get(num) + count.get(num+1));
            }
        }

        return max;
    }
}
