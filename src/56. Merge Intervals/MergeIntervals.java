import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MergeIntervals {
    /*
     * First try, when i tried "insert interval" problem, i commit a mistake
     * and tried to merge everything and i had to redo everything, but that 
     * reasoning helped me to solve this problem, i just keep track of previous
     * interval and if the actual interval start is less than or equal to previous end
     * then i merge them, otherwise i add the previous interval to the list and move to the next one, 
     * at the end i add the last interval to the list and return it as an array
     * 
     * Runtime: 8ms beats 90.41% 
     */
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

            List<int[]> ls = new ArrayList<>();

            int[] prev = intervals[0];
            for(int i = 1; i<intervals.length; i++){
                int[] actual = intervals[i];

                if(actual[0] <= prev[1]){
                    prev[1] = Math.max(actual[1],prev[1]);
                } else{
                    ls.add(prev);
                    prev = actual;
                }
            }

            ls.add(prev);
            return ls.toArray(new int[0][]);
        }
    }

}

