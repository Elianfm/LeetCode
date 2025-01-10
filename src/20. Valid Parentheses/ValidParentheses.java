import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
/* Third option, following same logic but easier to read
 * 2ms Beats 97.66%
 */
public boolean isValid(String s) {
    Deque<Character> deque = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
        switch(c){
            case '(','[','{':
                deque.push(c);
                break;
            case ')',']','}':
                if(deque.isEmpty() || !validParentheses(deque.pop(), c)) return false;
                break;
        }
    }

    return deque.isEmpty();
}

public boolean validParentheses(char previous, char actual) {
    switch (previous) {
        case '(': return actual == ')';
        case '[': return actual == ']';
        case '{': return actual == '}';
        default: return false;
    }
}


/* Second try, in this case, i tried to solve the problem using recursion
 * to practice the concept. 1ms Beats 99.66%
 */
/* 
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<Character>();
        return isValidRecurse(s, s.length() - 1, deque);

    }

    public boolean isValidRecurse(String s,
            int position,
            Deque<Character> deque) {

        if (position == -1)
            return deque.isEmpty();

        char actual = s.charAt(position);
        if ((actual == '(' || actual == '{' || actual == '[')) {
            if (deque.isEmpty()
                || !validParentheses(actual, deque.pop()))
            return false;
        } else {
            deque.push(actual);
        }

        return isValidRecurse(s, position - 1, deque);
    }

    public boolean validParentheses(char previous, char actual) {
        switch (previous) {
            case '(': return actual == ')';
            case '[': return actual == ']';
            case '{': return actual == '}';
            default: return false;
        }
    }
*/


/* First try */
/* 2ms Beats 97.66% */
/* 
    public boolean isValid(String s) {

        Deque<Character> deque = new ArrayDeque()<Character>();
        char actual = s.charAt(0);

        deque.push(actual);

        for(int i = 1; i< s.length(); i++){
            actual = s.charAt(i);

            if(actual == '('  || actual == '['  || actual == '{'){
                deque.push(actual);
            } else if (deque.isEmpty()){
                return false;
            } else if(validParentheses(deque.peek(), actual)) {
                deque.pop();
            } else{
                return false;
            }
        }

        if (deque.isEmpty()) return true;
        return false;

    }

    public boolean validParentheses(char previous, char actual){
        return (previous == '(' && actual == ')')
        || (previous == '[' && actual == ']')
        || (previous == '{' && actual == '}');
    }
*/

}