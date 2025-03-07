import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /*
     * First try, using recursion and backtracking
     * 
     * Runtime: 1ms beats 83.40%
     * Memory: 43.44mb beats: 36.90%
     */

     class Solution {

        List<String> parentheses = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
    
        public List<String> generateParenthesis(int n) {
            recursive(n-1, n, '(');
            return parentheses;
        }
    
        private void recursive(int numOpen, int numClose, Character manage) {
            if (numClose < 0 || numOpen < 0) return;
            if (numClose < numOpen) return;
            sb.append(manage);
            
            if (numClose == 0 && numOpen == 0)
                parentheses.add(sb.toString());
    
            recursive(numOpen-1, numClose, '(');
            recursive(numOpen, numClose-1, ')');
            sb.deleteCharAt(sb.length() - 1);
    
        }
    }
}
