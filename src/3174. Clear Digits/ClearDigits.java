import java.util.ArrayDeque;
import java.util.Deque;

class ClearDigits {

    /*
     * First try, i used a deque to store the characters
     * and a pending variable to store the number of digits that i need to remove.
     * Runtime: 2ms Beats 74.01%
     * Memory: 42.57MB Beats 74.50%
     */
    public String clearDigits(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int pending = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                pending++;
            } else {
                deque.push(c);
            }

            if (pending > 0) {
                if (deque.isEmpty()) {
                    pending++;
                } else {
                    deque.pop();
                    pending--;
                }
            }
        }

        return dequeToString(deque);
    }

    private String dequeToString(Deque deque) {
        StringBuilder sb = new StringBuilder();

        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }

        return sb.toString();
    }
}
