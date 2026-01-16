public class ImplementingQueueUsingStacks {

    /*
    * First try, similar to ImplementStackUsingQueues.java
    * using two stacks to implement a queue
    * 
    * push is O(1) but pop and peek are O(n)
    * we can invert it to make push O(n) and pop and peek O(1)
    * 
    * Runtime 0ms beats 100.00%
    */
    class MyQueue {
        // Stack methods:
        // peek()
        // pop()
        // push()

        Deque<Integer> myStack = new ArrayDeque<>();
        Deque<Integer> supportStack = new ArrayDeque<>();

        public MyQueue() { 
        }
        
        public void push(int x) {
            myStack.push(x);
        }
        
        public int pop() {
            keepLast();
            int last = myStack.pop();
            restore();
            return last;
        }
        
        public int peek() {
            keepLast();
            int last = myStack.peek();
            restore();
            return last; 
        }
        
        public boolean empty() {
            return myStack.isEmpty();
            
        }

        private void keepLast(){
            while(myStack.size() > 1)
                supportStack.push(myStack.pop());
        }

        private void restore(){
            if(!myStack.isEmpty()) supportStack.push(myStack.pop());
            while(!supportStack.isEmpty())
                myStack.push(supportStack.pop());
        }

    }
}
