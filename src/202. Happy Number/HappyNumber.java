public class HappyNumber {
    
    /*
     * First try, recursive approach, i found testing edge cases that
     * 7 turns into 1, so i added that as a base case. but all 
     * other single digit numbers turn into a loop that doesn't
     * include 1 or 7.
     * 
     * Runtime 0ms beats 100%
     */
    class Solution {
        public boolean isHappy(int n) {
            if(n == 1 || n == 7) return true;
            if(n < 10) return false;
            int nTemp = n;

            int sum = 0;
            while(nTemp > 0){
                int mod = nTemp % 10;
                sum += mod*mod;
                nTemp /= 10;
            }

            //return (sum == n) ? false : isHappy(sum); at first i tried this to catch loops but it wasn't necessary
            return isHappy(sum);
        }
    }
}
