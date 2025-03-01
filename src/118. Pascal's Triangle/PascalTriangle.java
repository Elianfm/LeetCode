import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /*
     * First try, recursive solution
     * 
     * Runtime: 0ms beats 100%
     * Memory: 41.90mb beats 77.37%
     * 
     */
    class Solution {

        int numRows;
        List<List<Integer>> rows = new ArrayList<>();
    
        public List<List<Integer>> generate(int numRows) {
            this.numRows = numRows;
            List<Integer> first = new ArrayList<>();
            first.add(1);
            rows.add(first);
            recursive(first, 0);
            return rows;
        }
    
        public void recursive(List<Integer> previousRow, int deep){
            if(deep == numRows-1) return;
    
            List<Integer> row = new ArrayList<>();
    
            row.add(1);
            for(int i=0; i<previousRow.size()-1; i++){
                row.add(previousRow.get(i) + previousRow.get(i+1));
            }
            row.add(1);
            rows.add(row);
    
            recursive(row, deep+1);
        }
    }

}
