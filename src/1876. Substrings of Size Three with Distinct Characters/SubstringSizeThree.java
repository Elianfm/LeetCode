
class SubstringSizeThree {

    /*
     * First try, i use a sliding window to solve this problem, i use a char array to
     * store the last two characters and compare them with the current character,
     * and if they are all different, i increment the counter.
     * 
     * Runtime: 1ms Beats 90.72%
     * Memory: 41.87MB Beats 51.54%
     */
    class Solution {
        public int countGoodSubstrings(String s) {
            int counter = 0;
    
            char[] c = new char[2];
    
            if(s.length() < 3) return 0;
    
            c[0] = s.charAt(0);
            c[1] = s.charAt(1);
    
            for(int i=2; i<s.length(); i++){
                char temp = s.charAt(i);
                if(c[0] != c[1] && c[0] != temp && c[1] != temp) counter++;
    
                c[0] = c[1];
                c[1] = temp;
            }
    
            return counter;
        }
    }

}
