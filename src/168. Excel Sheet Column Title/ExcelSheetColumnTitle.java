public class ExcelSheetColumnTitle {
    /*
     * First try, i remember Number1Bits problem, so i tried something
     * similar to that, but instead of dividing by 2, we divide by 26,
     * and we use modulo 26 to get the character to append to the result.
     * 
     * Runtime: 0ms beats 100%
     */
    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder("");
            while(columnNumber > 0){
                columnNumber--;
                int rest =  'A' + columnNumber%26;
                sb.append((char) rest);
                columnNumber /= 26;
            }

            return sb.reverse().toString();
        }
    }
}
