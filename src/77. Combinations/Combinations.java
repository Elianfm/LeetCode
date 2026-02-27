import java.util.ArrayList;
import java.util.List;

public class Combinations {

    /*
     * First try, backtracking solution, i explore recursively all the combinations of 
     * numbers from 1 to n, when i reach a combination of size k i add it to the final list. 
     * 
     * Runtime 18ms beats 81.87%
     */
    class Solution {
        List<List<Integer>> finalLs = new ArrayList<>();
        List<Integer> ls = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            explore(n,k,1);
            return finalLs;
        }

        private void explore(int n, int k, int actual){
            if(actual > n) return;
            explore(n, k, actual+1);

            ls.add(actual);

            if(ls.size() == k){
                finalLs.add(new ArrayList(ls));
            }else{
                explore(n, k, actual+1);
            }

            ls.remove(ls.size()-1);
        }
    }
}
