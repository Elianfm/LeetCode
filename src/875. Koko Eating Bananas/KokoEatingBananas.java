public class KokoEatingBananas {

    /*
     * First try, it works but it needs optimization.
     * My idea was using binary search to find the minimum eating speed Koko needs
     * to eat all bananas within H hours. But i got a little stuck on the
     * implementation.
     * 
     * Runtime: 25ms beats 26.65%
     */
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = piles[0];
            int min = 1;

            for(int n: piles)
                max = Math.max(max, n);

            return kokoThoughts(piles,h, min, max, max);
        }

        private int kokoThoughts(int[] piles, int h, int left, int right, int k){
            if(left > right) return Integer.MAX_VALUE;

            int kokoHours = 0;
            int eatRate = (left+right)/2;

            for(int i = 0; i<piles.length; i++)
                kokoHours += Math.ceil( (double) piles[i]/eatRate);

            if(kokoHours <= h) k = Math.min(k, eatRate);

            int exploration = (kokoHours <= h) 
                ? kokoThoughts(piles, h, left, eatRate-1, k)
                : kokoThoughts(piles, h, eatRate+1, right, k);

            return Math.min(k, exploration);

        }

    }
}
