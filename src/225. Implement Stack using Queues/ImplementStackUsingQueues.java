import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueues {

    /*
    * First try, following the hint of using two queues
    * i use one queue to store the elements, and another to help get the last element
    * Runtime 0ms beats 100.00%
    */
    class MyStack {
        // im gonna use arrayDeque and pretend as if the stack didn't exist
        // offer()
        // poll()
        // peek()
        Queue<Integer> inQueue = new ArrayDeque<>();
        Queue<Integer> support = new ArrayDeque<>();


        public MyStack() {
        }   
        
        public void push(int x) {
            inQueue.offer(x);
        }
        
        public int pop() {
            this.last();
            int last = inQueue.poll();
            this.restore();
            return last;
        }
        
        public int top() {
            this.last();
            int last = inQueue.peek();
            this.restore();
            return last;
        }
        
        public boolean empty() {
            return inQueue.isEmpty();
        }

        private void last(){
            while(inQueue.size()>1)
                support.offer(inQueue.poll()); 
        }

        private void restore(){
            if(!inQueue.isEmpty()) support.offer(inQueue.poll()); 
            while(!support.isEmpty())
                inQueue.offer(support.poll());
        }

    }
}
