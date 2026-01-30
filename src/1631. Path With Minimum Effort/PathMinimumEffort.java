public class PathMinimumEffort {

    // pending to try with Dijkstra

    /*
     * First try, TLE raw unclean ugly solution
     * My idea was exploring everything with DFS keeping track of the actual path effort
     * it works but is too slow
     */

    class Solution {
        int minPath = Integer.MAX_VALUE;
        int actualPath = 0;
        boolean[][] explored;

        public int minimumEffortPath(int[][] heights) {
            explored = new boolean[heights.length][heights[0].length];
            explore(heights, 0, 0, heights[0][0]);
            return minPath;
        }

        private void explore(int[][] heights, int row, int column, int prev){
            if(row >= heights.length || column >= heights[0].length
                || row < 0 || column < 0) return;
            
            if(row == heights.length -1 && column == heights[0].length-1){
                int actual = heights[row][column];
                int prevPath = actualPath;
                actualPath = Math.max(actualPath, Math.abs(prev - actual));
                minPath = Math.min(actualPath, minPath);
                actualPath = prevPath;
            }

            if(explored[row][column]) return;
            explored[row][column] = true;

            int actual = heights[row][column];
            int prevPath = actualPath;
            actualPath = Math.max(actualPath, Math.abs(prev - actual));

            explore(heights, row+1, column, actual);
            explore(heights, row-1, column, actual);
            explore(heights, row, column+1, actual);
            explore(heights, row, column-1, actual);

            actualPath = prevPath;

            explored[row][column] = false;

        }
    }




}
