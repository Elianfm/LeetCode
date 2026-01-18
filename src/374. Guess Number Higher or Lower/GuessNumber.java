public class GuessNumber {
    /** 
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
    *               otherwise return 0
    * int guess(int num);
    */

    /*
    * Using switch expression to make the code cleaner
    * Runtime: 0ms beats 100%
    */
   public class Solution2 extends GuessGame {
        public int guessNumber(int n) {
            return recursionGuess(1,n);
        }

        private int recursionGuess(int left, int right) {
            int mid = left + (right - left)/2;

            return switch(guess(mid)){
                case -1 -> recursionGuess(left, mid-1);
                case 0 -> mid;
                case 1 -> recursionGuess(mid+1, right);
                default -> 0;
            };
        }
    }


    /*
    * First try, classic binary search problem, i got first a error 
    * because of integer overflow when doing (left + right) / 2
    * so i changed it to left + (right - left) / 2 (safe mid calculation)
    * 
    * Runtime: 0ms beats 100%
    */
    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            return recursionGuess(1,n);
        }

        private int recursionGuess(int left, int right) {
            int mid = left + (right - left)/2;

            switch(guess(mid)){
                case -1:
                    return recursionGuess(left, mid-1);
                case 0:
                    return mid;
                case 1:
                    return recursionGuess(mid+1, right);
            }

            return 0;
        }
    }

    // just to avoid compilation error
    public class GuessGame {

        public int guess(int num) {
            return 0; 
        }
    }

}
