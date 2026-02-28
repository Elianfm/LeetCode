public class MeetingRoomsII {

    // first try was O(n^2) because of the two priority queues, but we can do it in O(nlogn)
    // using only a min-heap, pending to try it out

    /*
     * First try, i use two priority queues, one to store the intervals and another to store the intervals 
     * that are not possible to be used in the current day. I iterate over the first queue and if the start
     * of the interval is less than the end of the last interval used, i put it in the second queue, 
     * otherwise i update the end of the last interval used. At the end of the iteration, i update the first 
     * queue with the second queue and repeat until the first queue is empty. 
     * The number of iterations is the number of days needed.
     * 
     * Runtime 63ms beats 99.71%
     */
    class Solution {
        public int minMeetingRooms(List<Interval> intervals) {
            if(intervals.size() == 0) return 0;

            PriorityQueue<Interval> main = new PriorityQueue<>((a,b) -> Integer.compare(a.start, b.start));  
            PriorityQueue<Interval> sup = new PriorityQueue<>((a,b) -> Integer.compare(a.start, b.start));  

            for(Interval i: intervals) main.offer(i);

            int days = 0;
            while(main.size() > 0){
                days++;
                int endLastDay = -1;
                while(main.size() > 0){
                    Interval actual = main.poll();
                    if(endLastDay > actual.start){
                        sup.offer(actual);
                    }else{
                        endLastDay = actual.end;
                    }
                }
                main = sup;
                sup = new PriorityQueue<>((a,b) -> Integer.compare(a.start, b.start));
            }

            return days;
            
        }
    }
}
