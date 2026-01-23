import java.util.PriorityQueue;

public class LargestElementStream {

    /*
     * First try, using a priority queue adding elements till size k,
     * then polling the smallest when adding a new element if size > k.
     * 
     * Runtime 21ms beats 94.96%
     */
    class KthLargest {
        PriorityQueue<Integer> myNums = new PriorityQueue<>();
        int kth;

        public KthLargest(int k, int[] nums) {
            this.kth = k;
            for(int n:nums) add(n);
        }
        
        public int add(int val) {
            myNums.offer(val);
            if(myNums.size() > kth) myNums.poll();
            return myNums.peek();
        }
    }
}
