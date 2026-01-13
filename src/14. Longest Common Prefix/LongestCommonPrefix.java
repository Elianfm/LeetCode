public class LongestCommonPrefix {
    
    /*
    * First try, i found the minimum length string first, then i compared each character
    * of the strings until a difference is found. Complexity O(m*n) where m is the length of the
    * shortest string and n is the number of strings. 
    * 
    * Runtime 0ms beats 100%
    */
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int minString = strs[0].length();

            for(String s: strs){
                int len = s.length();
                minString = (len<minString) ? len: minString;
            }

            for(int i = 0; i<minString; i++){
                char first = strs[0].charAt(i);
                for(int j = 1; j<strs.length; j++){
                    if(first != strs[j].charAt(i)){
                        return strs[0].substring(0,i);
                    }
                }
            }

            return strs[0].substring(0, minString);        

        }
    }
}

