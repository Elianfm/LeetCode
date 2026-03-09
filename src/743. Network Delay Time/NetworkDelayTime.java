import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetworkDelayTime {

    /*
     * First try, trying to simulate the signal, but it is too slow
     * 
     * Runtime: TLE
     */
    class Solution {
        Map<Integer, ArrayList<Signal>> map;
        int[] minTime;

        public int networkDelayTime(int[][] times, int n, int k) {
            map = new HashMap<>();
            minTime = new int[n];
            Arrays.fill(minTime, Integer.MAX_VALUE);

            for(int i = 0; i<times.length; i++){
                ArrayList<Signal> al = map.getOrDefault(times[i][0], new ArrayList<>());
                al.add(new Signal(times[i][1], times[i][2]));
                map.put(times[i][0], al);
            }    

            emit(k, 0);

            int minAllTime = 0;
            for(int i: minTime)
                minAllTime = Math.max(minAllTime, i);

            return (minAllTime == Integer.MAX_VALUE) ? -1 : minAllTime;
            
        }

        private void emit(int node, int time){
            if(minTime[node-1] < time) return;

            minTime[node-1] = time;
            List<Signal> signals = map.getOrDefault(node, new ArrayList<>());

            for(Signal s: signals)
                emit(s.target, time + s.time);
            
        }


        private class Signal{
            int target;
            int time;

            public Signal(int target, int time){
                this.target = target;
                this.time = time;
            }
        }

    }
}
