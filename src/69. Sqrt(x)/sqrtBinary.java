public class sqrtBinary {

    /*
    * I realize i dont need two pow calculations each recursion! 
    */
    class Solution3 {
        public int mySqrt(int x) {
            // INTEGER MAX VALUE = 2_147_483_647
            // 46340 max pow
            return (x==0) ? x: searchSqrt(x,1,46340);
        }

        private int searchSqrt(int x, int left, int right){
            if (left > right) return right;

            int mid = (left + right) / 2;
            int powLow = mid*mid;

            if(x == powLow) return mid;

            return (x > powLow) ? searchSqrt(x, mid+1, right)
                    : searchSqrt(x,left, mid-1);
        }
    }

    /*
    * There's two ways, keep using long to avoid overflow on pow calculations
    * but exercise only asks for integers, so we can avoid using long
    * by limiting the right pointer to 46340, since 46340^2 = 2_147_395_600
    * and 46341^2 = 2_147_488_281 which is larger than Integer.MAX_VALUE
    * 
    * Runtime: 1ms beats 96.47%
    * 
    */
    class Solution2 {
        public int mySqrt(int x) {
            // INTEGER MAX VALUE = 2_147_483_647
            // 46340 max pow
            return (x==0) ? x: searchSqrt(x,1,46340);
        }

        private int searchSqrt(int x, int left, int right){
            int mid = (left + right) / 2;
            if(mid == 46340 ) return mid; // MAX

            int powLow = mid*mid;
            int powHigh = (mid+1) * (mid+1);

            if(x >= powLow && x < powHigh) return mid;

            return (x > powLow) ? searchSqrt(x, mid+1, right)
                    : searchSqrt(x,left, mid-1);
        }
    }


    /*
    * First try, binary search, i put right as x/2 because
    * the sqrt of x will never be larger than x/2 when x>1
    * 
    * Slow cuz i had to use Long to avoid overflow on pow calculations
    * Runtime: 2ms beats 12.64%
    */
    class Solution {
    public int mySqrt(int x) {
        return (x==0) ? x: searchSqrt(x,1,x/2);
    }

    private int searchSqrt(int x, int left, int right){
        int mid = left + (right - left) / 2;
        Long powLow = (long) mid*mid;
        Long powHigh = (long) (mid+1) * (mid+1);

        if(x >= powLow && x < powHigh) return mid;

        return (x > powLow) ? searchSqrt(x, mid+1, right)
                : searchSqrt(x,left, mid-1);
    }
}
}
