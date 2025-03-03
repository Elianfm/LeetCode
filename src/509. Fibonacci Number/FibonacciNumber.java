public class FibonacciNumber {

    /*
     * Second try, using DP, i just store last two values of the fibonacci sequence
     * and update them in each iteration (i also tried memoization but it's too slow)
     * 
     * Runtime 0ms Beats 100%
     * Memory: 40.73MB Beats 17.41%
     */

     class Solution2 {
        public int fib(int n) {
            if(n == 0 || n == 1) return n;
    
            int prev = 0;
            int prev2 = 1;
    
            for(int i=2; i<=n; i++){
                int act = prev + prev2;
                prev = prev2;
                prev2 = act;
            }
    
            return prev2;
        }
    }


    /*
     * First try, using recursion, i like this solution because it's simple and easy
     * to understand although it's not the most efficient solution
     * 
     * Runtime 9ms Beats 25.25%
     * Memory 40.50MB Beats 47.82%
     */

    class Solution {
        public int fib(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            return fib(n - 1) + fib(n - 2);
        }
    }
}
