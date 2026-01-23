import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    /*
     * First try, using a max-heap priority queue to always get the 2 heaviest
     * stones, repeating the crash til one or none stones are left.
     * 
     * Runtime 1ms beats 99.42%
     */
    class Solution {
        PriorityQueue<Integer> heavy 
            = new PriorityQueue<>(Collections.reverseOrder());
        
        public int lastStoneWeight(int[] stones) {
            for(int s: stones) heavy.offer(s);

            while(heavy.size()>1){
                int stone1 = heavy.poll();
                int stone2 = heavy.poll();

                if(stone1 != stone2) heavy.offer(stone1-stone2);
            }

            return (heavy.isEmpty()) ? 0 : heavy.poll();
        }

    }
}
