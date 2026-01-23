public class RomanToInteger {

    /*
     * i found there's a way to do this without too much comparations,
     * by checking if the current character is less than the next one.
     * I also realize that map was slowing down the solution, so i
     * created a method to get the value of each roman numeral.
     * 
     * Runtime: 2ms beats 99.53%
     */

    class Solution {
        public int romanToInt(String s) {
            int prev = value(s.charAt(0));
            int sum = prev;

            for(int i = 1; i<s.length(); i++){
                int actual = value(s.charAt(i));

                if (prev < actual)
                    sum -= 2 * prev;
                
                sum += actual;
                prev = actual;
            }

            return sum;
        }

        private int value(char c) {
            switch (c) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
    }

    /*
     * First try, hashmap, i sum everything and if there's a combination
     * that requires subtraction i subtract double the value of the previous
     * character (because it was already added once).
     * 
     * Runtime: 4ms beats 57.99%
     */
    class Solution {
        public int romanToInt(String s) {

            Map<Character,Integer> map = new HashMap<>();

            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);

            char prev = s.charAt(0);
            int sum = map.get(prev);

            for(int i = 1; i<s.length(); i++){
                char actual = s.charAt(i);
                if(prev == 'I' && (actual == 'V' || actual == 'X')
                    || prev == 'X' && (actual == 'L' || actual == 'C')
                    || prev == 'C' && (actual == 'D' || actual == 'M')
                )
                    sum -= 2*map.get(prev);
                
                sum += map.get(actual);
                prev = actual;
            }

            return sum;
        }
    }
}
