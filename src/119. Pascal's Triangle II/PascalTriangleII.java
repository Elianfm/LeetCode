import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    /*
     * First try, recursive solution
     * 
     * Runtime: 1ms beats 66.23%
     * Memory: 40.96MB beats 90.49%
     */


     class Solution {

        List<Integer> list = new ArrayList<>();
    
        public List<Integer> getRow(int rowIndex) {
            list.add(0,1);
            
            if(rowIndex==0) return list;
    
            for(int i = 0; i<list.size()-1; i++){
                list.set(i,list.get(i) + list.get(i+1));
            }
    
            return getRow(rowIndex-1);
        }
    
    }
}
