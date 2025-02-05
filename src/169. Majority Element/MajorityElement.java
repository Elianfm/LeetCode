import java.util.LinkedList;
import java.util.Queue;

/* PENDING TO OPTIMIZE */
class MajorityElement {


    /* First try, this time i tried a queue for
     * storing the elements and removing if found
     * another element that is not the same
     * 
     * Runtime: 8ms Beats 30.07%
     * Memory: 50.7MB Beats 70.32%
     */

     public int majorityElement(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        for(int n : nums){
            if(queue.peek() == null){
                queue.offer(n);
                continue;
            }

            if(queue.peek() == n){
                queue.offer(n);
            } else{
                queue.remove();
            }
        }

        return queue.peek();
    }

}
