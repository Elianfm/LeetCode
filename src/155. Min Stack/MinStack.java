/*
 * First try, I use two stacks to construct a min stack
 * One stack holds the values, and the other holds the minimums
 *  
 * Runtime: 4ms beats 97.47%
 */
public class MinStack {
    //And so, Dave constructed a megaphone, using only some string, 
    //a squirrel, and a megaphone!
    Deque<Integer> values = new ArrayDeque<>();
    Deque<Integer> mins = new ArrayDeque<>();

    public MinStack() {}
    
    public void push(int val) {
        values.push(val);
        if(mins.isEmpty() || val <= mins.peek()) mins.push(val);
    }
    
    public void pop() {
        int val = values.pop();
        if(val == mins.peek()) mins.pop();
    }
    
    public int top() {
        return values.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
