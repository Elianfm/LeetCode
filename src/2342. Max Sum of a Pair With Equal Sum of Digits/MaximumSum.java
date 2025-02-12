import java.util.HashMap;
import java.util.Map;

class MaximumSum {

    /* 
     * First try, i use two hashmaps, one to store the highest number for each sum of digits, 
     * and the other to store the maximum sum of a pair with equal sum of digits.
     * Runtime: 45ms Beats 63.03%
     * Memory: 55.18MB Beats 96.45%
     */

     public int maximumSum(int[] nums) {
        
        Map<Integer, Integer> higher = new HashMap<>();
        Map<Integer, Integer> maxsum = new HashMap<>();

        int sumD;
        int top;
        for(int n: nums){
            sumD = sumD(n);

            if(!higher.containsKey(sumD)){
                higher.put(sumD, n);
                continue;
            }

            top = higher.get(sumD);

            if(maxsum.containsKey(sumD)){
                if(maxsum.get(sumD) < top+n) maxsum.put(sumD, top+n);
            }else{
                maxsum.put(sumD, top+n);
            }

            if(n > top) higher.put(sumD, n);
        }

        int maxsumfinal = -1;
        for(int n : maxsum.values()){
            if(n > maxsumfinal) maxsumfinal = n;
        }

        return maxsumfinal;
    }

    // sum of digits
    private int sumD(int n){
        int digits = 0;
        while(n != 0){
            digits += n%10;
            n = n/10;            
        }
        return digits;
    }
}
