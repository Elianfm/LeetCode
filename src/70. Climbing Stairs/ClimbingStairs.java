import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    /*
     * THIRD TRY -
     * I found a interesting technique called memoization 
     * that can be used to optimize the recursive approach. 
     * I will try to implement it.
     * 
     * Runtime: 0ms - Beats 100%
     * Memory 40.32MB - Beats 61.65%
     */

    Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if (memo.containsKey(n))
            return memo.get(n);
        if (n <= 1)
            return 1;

        int resultado = climbStairs(n - 1) + climbStairs(n - 2);
        memo.put(n, resultado);
        return resultado;
    }

    /*
     * SECOND TRY - first try works! so i try to reimplement it with a cleaner code
     * it was classic Fibonacci sequence in recursive form.
     * but Leetcode gives me a Time Limit Exceeded error.
     */

    /*
     * public int climbStairs(int n) {
     * return (n <= 1) ? 1 : climbStairs(n-1) + climbStairs(n-2);
     * }
     */

    /*
     * FIRST TRY - I manually simulate the cases and find a pattern
     * similar to the Fibonacci sequence. So i try a basic implementation
     * to check if it works.
     */

    /*
     * public int climbStairs(int n) {
     * int previous = 0;
     * int actual = 1;
     * int sum = 1;
     * 
     * while(n-->0){
     * actual = sum;
     * sum = previous + actual;
     * previous = actual;
     * }
     * 
     * return sum;
     * }
     */
}
