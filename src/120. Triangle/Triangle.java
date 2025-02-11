import java.util.ArrayList;
import java.util.List;

public class Triangle {

    /*
     * Third try, bottom-up approach but with array,
     * it's more efficient than using List to access elements
     * Runtime: 2ms Beats 78.50%
     * Memory: 43.68MB Beats 94.34%
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
    
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
    
        return dp[0]; 
    }

    /*
     * Second try, bottom-up approach
     * It works, but it's still not efficient
     * Runtime: 8ms Beats 17.68%
     * Memory: 44.29MB Beats 53.94%
     */

    /*
     * public int minimumTotal(List<List<Integer>> triangle) {
     * 
     * for(int i = triangle.size()-2; i >= 0; i--){
     * for(int j = 0; j<triangle.get(i).size(); j++){
     * int min = triangle.get(i).get(j);
     * int min_a = triangle.get(i+1).get(j);
     * int min_b = triangle.get(i+1).get(j+1);
     * 
     * min += (min_a < min_b) ? min_a : min_b;
     * triangle.get(i).set(j, min);
     * }
     * }
     * 
     * return triangle.get(0).get(0);
     * }
     */

    /*
     * First try, Divide and Conquer with memoization
     * It works, but it's not efficient
     * Runtime: 13ms Beats 5.18%
     * Memory: 45.18MB Beats 13.75%
     */

    /*
     * List<List<Integer>> triangle = new ArrayList()<>();
     * 
     * //memoizacion
     * Map<String, Integer> map = new HashMap<>();
     * 
     * public int minimumTotal(List<List<Integer>> triangle) {
     * this.triangle = triangle;
     * return findMin(0,0);
     * }
     * 
     * private int findMin(int row, int column){
     * if(row > triangle.size()-1) return 0;
     * 
     * String pos = row + "," + column;
     * if(map.containsKey(pos)) return map.get(pos);
     * 
     * int min = triangle.get(row).get(column);
     * 
     * int min_a = findMin(row+1, column);
     * int min_b = findMin(row+1, column+1);
     * 
     * min += (min_a<min_b) ? min_a : min_b;
     * map.put(pos, min);
     * 
     * return min;
     * }
     */

}
