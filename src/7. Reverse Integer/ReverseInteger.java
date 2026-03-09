public class ReverseInteger {

    /*
     * First try, i was using stringbuilder at first but then i realize i cant use it because
     * of integer limits and the exercise says i cant use long o similars, so i just keep 
     * iterating the number and building the inverse, but i have to check if the inverse is going to 
     * be bigger than the max value before multiplying it by 10, because if it is, then it is going to be 
     * bigger than the max value after multiplying it by 10 and will cause an overflow, so i return 0 in that case.
     *
     * Runtime: 1ms 99.87%
     */
    class Solution2 {
        public int reverse(int x) {
            boolean negative = false;
            if(x < 0) negative = true;
            x = Math.abs(x);
            int inverse = 0;

            int maxValue = Integer.MAX_VALUE/10;
            
            while(x > 0){
                int temp = x%10;
                if(inverse > maxValue) return 0;
                inverse *= 10;
                inverse += temp;
                x /= 10;
            }

            return (negative) ? (-1 * inverse) : inverse;
        }
    }

    /*
     * Zero try, no valid but i wanted to try it out anyways
     * 3ms beats 5.70%
     */
    class Solution {
        public int reverse(int x) {
            String s = String.valueOf(x);
            StringBuilder sb = new StringBuilder();

            if (x<0) {
                sb.append('-');
                sb.append(new StringBuilder(s.substring(1)).reverse());
            } else {
                sb.append(new StringBuilder(s).reverse());
            }

            long temp = Long.parseLong(sb.toString());

            return (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
                    ? 0
                    : (int) temp;
        }
    }
}
