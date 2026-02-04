import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    /*
     * First try, using ArrayList, if the new interval doesn't overlap, i 
     * added it directly, otherwise I update the first and last values
     * 
     * Runtime: 1ms beats 97.65%
     */
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> newArr = new ArrayList<>();

            int first = newInterval[0];
            int last = newInterval[1];
            boolean added = false;
        
            for(int i = 0; i<intervals.length; i++){
                int[] actual = intervals[i];

                if(actual[1] < newInterval[0] || actual[0] > newInterval[1]){
                    if(actual[0] > newInterval[1] && !added){
                        newArr.add(new int[] {first, last});
                        added = true;
                    }
                    newArr.add(actual);
                    continue;
                }

                first = Math.min(actual[0], first);
                last = Math.max(actual[1], last);
            }

            if(!added) newArr.add(new int[] {first, last});
            
            return newArr.toArray(new int[newArr.size()][2]);
        }
    }
}
