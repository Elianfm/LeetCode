import java.util.Arrays;

public class NonOverlappingIntervals {


    /*
     * Same as first try, but instead of exploring recursively i do it iteratively,
     * and i keep track only of the end of the previous interval
     * 
     * Runtime 48ms beats 42.72%
     */
    class Solution2 {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
            int end = intervals[0][1];
            int removed = 0;

            for(int i = 1; i<intervals.length; i++){
                int[] actual = intervals[i];

                if(end > actual[0]){
                    end = Math.min(end,actual[1]);
                    removed++;
                    continue;
                }

                end = actual[1];
            }

            return removed;

        }
    }


    /*
     * First try, i sort then i explore, if i find an overlap, i check which one has the smallest end, 
     * and i keep it, then i continue exploring, if i find another overlap, i do the same thing, and so
     * on until the end of the array. It works because previous intervals are already explored, so if i find an overlap, 
     * i just need to check the end of the previous interval and the actual one, and keep the one with the smallest end, 
     * because it will give me more space to fit other intervals.
     * 
     * Runtime 50ms beats 26.23%
     */
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
            return explore(intervals, 1, intervals[0]);
        }

        private int explore(int[][] intervals, int pos, int[] prev){
            if(pos == intervals.length) return 0;
            int[] actual = intervals[pos];

            if(prev[1] > actual[0])
                return (prev[1] < actual[1])
                    ? explore(intervals, pos+1, prev) +1 
                    : explore(intervals, pos+1, actual) +1;

            return explore(intervals, pos+1, actual);
        }
    }
}
