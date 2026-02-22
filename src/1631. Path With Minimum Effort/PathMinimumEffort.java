import java.util.Arrays;
import java.util.PriorityQueue;

public class PathMinimumEffort {

    /*
     * Cleaner but slightly slower, similar to solution3 
     * Runtime 43ms beats 53.69%
     */
    class Solution4 {
        PriorityQueue<MyNode> next = new PriorityQueue<>((a,b) -> Integer.compare(a.cost, b.cost));
        int[][] heights;
        int[][] costs;

        public int minimumEffortPath(int[][] heights) {
            this.heights = heights;
            this.costs = new int[heights.length][heights[0].length];
            next.offer(new MyNode(0,0,0));
            costs[0][0] = 0;
            
            for(int i = 0; i<heights.length; i++) 
                Arrays.fill(costs[i], Integer.MAX_VALUE);

            while(true){
                MyNode n = next.poll();
                if(n.cost > costs[n.row][n.col]) continue;
                if(n.row == heights.length-1 && n.col == heights[0].length-1) return n.cost;
                if(n.col < heights[0].length-1) explore(n, n.row, n.col+1);
                if(n.col > 0) explore(n, n.row, n.col-1);
                if(n.row < heights.length-1) explore(n, n.row+1, n.col);
                if(n.row > 0) explore(n, n.row-1, n.col);
            }

        }

        private void explore(MyNode n, int row, int col){
            int cellCost = Math.max(n.cost,
                    Math.abs(heights[row][col] - heights[n.row][n.col]));

            if(cellCost < costs[row][col]){
                next.offer(new MyNode(row, col, cellCost));
                costs[row][col] = cellCost;
            }
        }

        private class MyNode{
            int row;
            int col;
            int cost;

            public MyNode(int row, int col, int cost){
                this.row = row;
                this.col = col;
                this.cost = cost;
            }
        }
    }


    /*
     * Third try, Dijkstra algorithm, faster
     * Runtime 36ms beats 99.15%
     */
    class Solution3 {
        
        PriorityQueue<MyNode> pq;
        int[][] dist;

        public int minimumEffortPath(int[][] heights) {
            pq = new PriorityQueue<>( (a,b) ->
                Integer.compare(a.cost, b.cost) );
        

            dist = new int[heights.length][heights[0].length];

            for(int i = 0; i < heights.length; i++){
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }

            dist[0][0] = 0;
            pq.offer(new MyNode(0,0,0));

            while(true){
                MyNode actual = pq.poll();
                if(actual.cost > dist[actual.row][actual.col]) continue;

                if(actual.row == heights.length-1 && actual.col == heights[0].length-1)
                    return actual.cost;

                addCosts(heights, actual.row, actual.col, actual);
            }



        }

        private void addCosts(int[][] heights, int row, int col, MyNode origin){
            int actual = heights[row][col];

            if(row < heights.length - 1){
                int bestCost = Math.max(Math.abs(actual - heights[row+1][col]), origin.cost);
                if(bestCost < dist[row+1][col]){
                    dist[row+1][col] = bestCost;
                    pq.offer(new MyNode(bestCost, row+1, col));
                }
            }

            if(col < heights[0].length - 1){
                int bestCost = Math.max(Math.abs(actual - heights[row][col+1]), origin.cost);
                if(bestCost < dist[row][col+1]){
                    dist[row][col+1] = bestCost;
                    pq.offer(new MyNode(bestCost, row, col+1));
                }
            }

            if(row > 0){
                int bestCost = Math.max(Math.abs(actual - heights[row-1][col]), origin.cost);
                if(bestCost < dist[row-1][col]){
                    dist[row-1][col] = bestCost;
                    pq.offer(new MyNode(bestCost, row-1, col));
                }
            }

            if(col > 0){
                int bestCost = Math.max(Math.abs(actual - heights[row][col-1]), origin.cost);
                if(bestCost < dist[row][col-1]){
                    dist[row][col-1] = bestCost;
                    pq.offer(new MyNode(bestCost, row, col-1));
                }
            }
        }


        private class MyNode{
            int cost;
            int row;
            int col;

            public MyNode(int cost, int row, int col){
                this.cost = cost;
                this.row = row;
                this.col = col;
            }
        }
    }


    /*
     * Second try, Dijkstra algorithm but slow
     * 
     * Runtime 73ms beats 16.72%
     * 
     */
    class Solution2 {
        
        boolean[][] visited;
        PriorityQueue<MyNode> pq;

        public int minimumEffortPath(int[][] heights) {
            pq = new PriorityQueue<>( (a,b) ->
                Integer.compare(a.cost, b.cost) );
            visited = new boolean[heights.length][heights[0].length];

            pq.offer(new MyNode(0,0,0));

            while(true){
                MyNode actual = pq.poll();
                if(visited[actual.row][actual.col]) continue;

                if(actual.row == heights.length-1 && actual.col == heights[0].length-1)
                    return actual.cost;

                visited[actual.row][actual.col] = true;
                addCosts(heights, actual.row, actual.col, actual);
            }



        }

        private void addCosts(int[][] heights, int row, int col, MyNode origin){
            int actual = heights[row][col];

            if(row < heights.length - 1){
                int bestCost = Math.max(Math.abs(actual - heights[row+1][col]), origin.cost);
                pq.offer(new MyNode(bestCost, row+1, col));
            }

            if(col < heights[0].length - 1){
                int bestCost = Math.max(Math.abs(actual - heights[row][col+1]), origin.cost);
                pq.offer(new MyNode(bestCost, row, col+1));
            }

            if(row > 0){
                int bestCost = Math.max(Math.abs(actual - heights[row-1][col]), origin.cost);
                pq.offer(new MyNode(bestCost, row-1, col));
            }


            if(col > 0){
                int bestCost = Math.max(Math.abs(actual - heights[row][col-1]), origin.cost);
                pq.offer(new MyNode(bestCost, row, col-1));
            }
        }


        private class MyNode{
            int cost;
            int row;
            int col;

            public MyNode(int cost, int row, int col){
                this.cost = cost;
                this.row = row;
                this.col = col;
            }
        }
    }

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
