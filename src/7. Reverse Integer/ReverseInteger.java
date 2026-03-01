public class ReverseInteger {

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
