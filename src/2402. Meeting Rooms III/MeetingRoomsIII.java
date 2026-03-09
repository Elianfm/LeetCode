import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {


    /* My first hard :D !
     * First try, my initial idea was to use one pq to store rooms comparing end time,
     * another pq to store rooms and another pq to store meetings comparing start time.
     * It doesn't work. A lot of bugs and was pretty slow (i was using a pq to poll all
     * available rooms for every meeting and then offer again to the main pq, so it was pretty inefficient).
     * But after some chatgpt debugging (only to find some bugs, not to solve the problem lol (like long vs int or pq comparators)) 
     * and refactoring i got this solution. Similar, but using two pq (to avoid removing and adding rooms to the main pq)
     * and sorting the meetings array instead of using a pq for it. (at first i was too adding meetings to a pq and then polling them,
     * but it was pretty slow).
     * 
     * Runtime: 78ms beats 36.18%
     */
    class Solution {
        public int mostBooked(int n, int[][] meetings) {
            PriorityQueue<Room> busy = new PriorityQueue<>(
                (a,b) -> {
                    if(a.end != b.end) return Long.compare(a.end, b.end);
                    return Integer.compare(a.numRoom, b.numRoom);
                }
            );
            PriorityQueue<Room> available = new PriorityQueue<>((a,b) -> Integer.compare(a.numRoom, b.numRoom));

            for(int i = 0; i<n; i++)
                available.offer(new Room(-1,-1,i));
            
            Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));
            for(int i = 0; i<meetings.length;i++){
                int[] actualMeeting = meetings[i];
                Room bestRoom = null;

                while(!busy.isEmpty() && busy.peek().end <= actualMeeting[0])
                    available.offer(busy.poll());
                
                if(!available.isEmpty()){
                    bestRoom = available.poll();
                    bestRoom.start = actualMeeting[0];
                    bestRoom.end = actualMeeting[1];
                }else{
                    bestRoom = busy.poll();
                    bestRoom.end += actualMeeting[1] - actualMeeting[0];
                }

                bestRoom.count++;
                busy.offer(bestRoom);

            }

            int roomSelected = 0;
            int bestCount = 0;

            while(!available.isEmpty()){
                Room rm = available.poll();
                if(rm.count > bestCount){
                    roomSelected = rm.numRoom;
                    bestCount = rm.count;
                }else if(rm.count == bestCount && rm.numRoom < roomSelected){
                    roomSelected = rm.numRoom;
                }
            }

            while(!busy.isEmpty()){
                Room rm = busy.poll();
                if(rm.count > bestCount){
                    roomSelected = rm.numRoom;
                    bestCount = rm.count;
                }else if(rm.count == bestCount && rm.numRoom < roomSelected){
                    roomSelected = rm.numRoom;
                }
            }

            return roomSelected;

        }


        private class Room{
            long start;
            long end;
            int numRoom;
            int count;

            public Room(int start, int end, int numRoom){
                this.start = start;
                this.end = end;
                this.numRoom = numRoom;
                this.count = 0;
            }
        }
    }
}
