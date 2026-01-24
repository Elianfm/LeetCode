import java.util.Collections;
import java.util.List;

public class MeetingRooms {

    /*
     * Optimized, i sort intervals by start time in this way we can 
     * compare each interval without needing of all timeline comparison.
     */
    class Solution2{
        public boolean canAttendMeetings(List<Interval> intervals) {
            Collections.sort(intervals, (a, b) -> a.start - b.start);

            for (int i = 1; i < intervals.size(); i++) 
                if (intervals.get(i).start < intervals.get(i - 1).end) 
                    return false;
                
            return true;
        }
    }

    /*
     * First try, using a boolean array to mark occupied time slots.
     * 
     * Runtime 84ms 
     */
    class Solution {
        public boolean canAttendMeetings(List<Interval> intervals) {
            boolean[] schedule = new boolean[1_000_000];

            for(Interval in: intervals){
                if(schedule[in.start]) return false;

                for(int i = in.start; i<in.end;i++){
                    if(schedule[i]) return false;
                    schedule[i] = true;
                }
            }

            return true;
        }
    }

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
