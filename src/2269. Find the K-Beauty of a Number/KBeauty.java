public class KBeauty {
    /*
     * First try, i convert the number to string and check if the number is k-beauty
     * with a sliding window, if the number is not zero and the number is divisible
     * by the substring, i increment the counter.
     * 
     * Runtime 0ms Beats 100%
     * Memory 40.36MB Beats 87.60%
     */

     class Solution {
        public int divisorSubstrings(int num, int k) {
            String number = String.valueOf(num);
            int counter = 0;
    
            
            for(int i = 0; i+k-1<number.length(); i++){
                int check = Integer.parseInt(number.substring(i,i+k));
                if(check != 0 && num%check == 0) counter++;
            }
    
            return counter;
        }
    }
}
