public class Tribonacci {
    /*
     * Second try, i wanna learn DP so i decided to solve this problem using DP too
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 40.44 Beats 48.95%
     */
    class Solution2{

        public int tribonacci(int n) {
            if(n == 0) return 0;
            if(n < 3) return 1;
    
            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;
    
            for(int i = 3; i<=n; i++){
                dp[i] = dp[i-1] +  dp[i-2] +  dp[i-3];
            }
    
            return dp[n];
        }
    }



    /*
     * First try, using recursion with memoization but it was extremely slow
     * so i decided to use a sliding window + DP to solve the problem
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 40.61mb Beats 27.13%
     */
    class Solution {

        public int tribonacci(int n) {
            if(n == 0) return 0;
            if(n < 3) return 1;
    
            int[] window = new int[3];
            window[0] = 0;
            window[1] = 1;
            window[2] = 1;
    
            for(int i = 3; i<=n; i++){
                int actual = window[0] + window[1] + window[2];
                window[0] = window[1];
                window[1] = window[2];
                window[2] = actual;
            }
    
            return window[2];
        }
    }
}
