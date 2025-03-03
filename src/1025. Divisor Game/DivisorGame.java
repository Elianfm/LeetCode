public class DivisorGame {

    /*
     * First try, after some minutes of DP, recursion and memoization, i realized
     * that the solution is very simple, if n is even, alice wins, if n is odd, bob
     * wins... ._.
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 40.35MB Beats 65.29%
     */

     class Solution {
        public boolean divisorGame(int n) {
            return (n % 2 == 0);
        }
    }
}
