public class LongestTurbulentSubarray {


    /*
     * First try, at first i tried an double path approach where if it was even or odd
     * i would check if the next element was greater or less than the current one, 
     * but it didn't work because was a static approach, so i changed it to a 
     * dynamic approach where i check if the last comparison was greater or less than and 
     * if the next one is the opposite, if it is, i increase the current count, if not, 
     * i update the best count and reset the current count to 2 because the current element 
     * and the previous one are already a turbulent subarray of size 2. If the elements are equal,
     * i update the best count and reset the current count to 1 because the current element alone 
     * is a turbulent subarray of size 1.
     * 
     * Runtime 4ms beats 99.71%
     */
    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int best = 1;
            int current = 1;
            boolean greater = false;

            for(int i = 1; i<arr.length; i++){
                int actual = arr[i];
                int prev = arr[i-1];

                if(actual == prev){
                    best = Math.max(best, current);
                    current = 1;
                    continue;
                }

                if(greater){
                    if(prev < actual){
                        current++;
                        greater = false;
                    }else{
                        best = Math.max(best, current);
                        current = 2;
                    }
                }else{
                    if(prev < actual){
                        best = Math.max(best, current);
                        current = 2;
                    }else{
                        current++;
                        greater = true;
                    }
                }

            }

            return Math.max(best, current);

        }
    }
}
