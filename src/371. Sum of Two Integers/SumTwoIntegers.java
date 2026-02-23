public class SumTwoIntegers {
    /*
     * First try, after some time cacharreando with bitwise, i got this solution
     * Idea is simple, if two bits are 0, then i do nothing, if one bit is 1, then i 
     * set a as the xoring of a and b, if both bits are 1 y set b as the and of a and b, 
     * but shifted to left, because if both bits are 1, then i have to sum 1 to the next bit.
     * Finally, when b is 0, it means there's not more a&b and b is 0, so i can return a
     * I approved kinderganden rn i'm so happy lol :D
     * 
     * Runtime 0ms beats 100%
     */

    class Solution {
        public int getSum(int a, int b) {
            while(b != 0){
                int xors = a^b;
                b &= a;
                b <<= 1;
                a = xors;
            }

            return a;
        }
    }
}
