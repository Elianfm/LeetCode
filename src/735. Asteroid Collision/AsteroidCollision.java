import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    // peding to refactor, the code is a bit messy, but it works and it's fast, I will try to make it cleaner later

    /*
     * First try, i used a stack to store the asteroids, and for each new asteroid, I check if it collides with the previous one, 
     * if it does, I pop the previous one and check again until I find a non-colliding asteroid or the stack is empty.
     * 
     * Runtime 2ms beats 97.49%
     */

    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> dq = new ArrayDeque<>();
            dq.push(asteroids[0]);

            for(int i = 1; i<asteroids.length; i++){
                int actual = asteroids[i];

                if(actual > 0){
                    dq.push(actual);
                    continue;
                }


                while(true){
                    if(dq.isEmpty()){
                        dq.push(actual);
                        break;
                    }

                    int prev = dq.pop();
                    int prevAbs = Math.abs(prev);
                    int actualAbs = Math.abs(actual);

                    if(prev < 0){
                        dq.push(prev);
                        dq.push(actual);
                        break;
                    }

                    if(prevAbs == actualAbs) break;

                    if(prevAbs > actualAbs){
                        dq.push(prev);
                        break;
                    }
                }

                
            }

            int[] output = new int[dq.size()];
            for(int i = 0; i<output.length; i++) output[i] = dq.removeLast();
            return output;

        }
    }
}
