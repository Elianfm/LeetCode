import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    /*
     * First try, using a stack and a switch
     * 
     * Runtime: 5ms beats 97.39%
     * Memory: 44.80mb beats 43.27%
     */
    class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            switch (token) {
                case "+" -> nums.push(nums.pop() + nums.pop());

                case "-" -> {
                    int b = nums.pop(), a = nums.pop();
                    nums.push(a - b);
                }

                case "*" -> nums.push(nums.pop() * nums.pop());

                case "/" -> {
                    int b = nums.pop(), a = nums.pop();
                    nums.push(a / b);
                }
                
                default -> nums.push(Integer.parseInt(token));
            }
        }

        return nums.pop();
    }
}
}
