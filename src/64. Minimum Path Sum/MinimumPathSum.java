import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPathSum {
    /*
     * Second try, Dijikstra version, its slower than DP but its a good try
     * to practice Dijikstra 
     * 
     * Runtime: 19ms beats 10.62%
     */

    class Solution2 {
        PriorityQueue<MyNode> pq;
        int lenRow;
        int lenCol;

        int[][] dist;

        public int minPathSum(int[][] grid) {

            lenRow = grid.length;
            lenCol = grid[0].length;
            if(lenRow == 1 && lenCol == 1) return grid[0][0];


            dist = new int[lenRow][lenCol];
        
            for(int i = 0; i<dist.length; i++)
                Arrays.fill(dist[i], Integer.MAX_VALUE);

            dist[0][0] = grid[0][0];

            pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.sum, b.sum));

            pq.offer(new MyNode(0,0,0));

            while(true){
                MyNode nd = pq.poll();   

                if (nd.row == lenRow-1 && nd.col == lenCol-1)
                    return nd.sum;

                if(nd.sum > dist[nd.row][nd.col]) continue;
                addPath(grid, nd.row +1, nd.col, dist[nd.row][nd.col]);
                addPath(grid, nd.row, nd.col+1, dist[nd.row][nd.col]);
                //addPath(grid, nd.row-1, nd.col, dist[nd.row][nd.col]);
                //addPath(grid, nd.row, nd.col-1, dist[nd.row][nd.col]);
            }

        }

        private void addPath(int[][] grid, int row, int col, int prevSum){
            if(row < 0 || col < 0 
                || row >= lenRow || col >= lenCol) return;

            int actual = grid[row][col];
            int sum = prevSum + actual;
            if(sum < dist[row][col]){
                dist[row][col] = sum;
                pq.offer(new MyNode(row,col,sum));
            }
        }

        private class MyNode{
            int row;
            int col;
            int sum;

            public MyNode(int row, int col, int sum){
                this.row = row;
                this.col = col;
                this.sum = sum;
            }
        }
    }



    /*
     * First try, i realized i can sum every cell selecting the minimum if it's not the first row or column.
     * like this;
     * 
     *  1  3  1     1  4  5      1  4  5      1  4  5     1  4  5
     *  1  5  1  => 2  5  1  =>  2  7  1  =>  2  7  6 =>  2  7  6
     *  4  2  1     6  2  1      6  2  1      6  8  1     6  8  7
     * 
     * so its DP.
     * 
     * Runtime: 3ms beats 75.03%
     * Memory: 47.35mb beats 89.14%  
     */

     class Solution {
        public int minPathSum(int[][] grid) {
            int lenA = grid.length;
            int lenB = grid[0].length;
    
            for (int i = 1; i < lenA; i++) {
                grid[i][0] += grid[i - 1][0];
            }
    
            for (int i = 1; i < lenB; i++) {
                grid[0][i] += grid[0][i - 1];
            }
    
            for (int i = 1; i < lenA; i++) {
                for (int j = 1; j < lenB; j++) {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
    
            return grid[lenA-1][lenB-1];
    
        }
    }
}
