public class BaseballGame {
    /*
    * First try, using a stack to store the scores
    * Runtime 2ms beats 90.21%
    */

    class Solution {
        public int calPoints(String[] operations) {
            ArrayDeque<Integer> q = new ArrayDeque<>();

            for(String s: operations){
                switch(s){
                    case "+":
                        int lastScore = q.pop();
                        int newScore = lastScore + q.peek();
                        q.push(lastScore);
                        q.push(newScore);
                        break;
                    case "D":
                        q.push(q.peek() * 2);
                        break;
                    case "C":
                        q.pop();
                        break;
                    default:
                        q.push(Integer.parseInt(s));
                        break;
                }
            }

            int sum = 0;
            int size = q.size();
            for(int i = 0; i<size; i++) sum += q.pop();
            return sum;
        }
    }
}
