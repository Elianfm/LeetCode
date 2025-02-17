class IslandPerimeter {

    /*
     * PENDING TRY With normal iteration
     */

    /*
     * First try using DFS
     * Runtime: 7ms Beats 30.38%
     * Memory: 46.12MB Beats 23.84%
     */

     int[][] grid;
     int rows;
     int columns;
 
     public int islandPerimeter(int[][] grid) {
         this.grid = grid;
         this.rows = grid.length;
         this.columns = grid[0].length;
 
         int perimeter = 0;
 
         for(int i = 0; i<rows;i++){
             for(int j = 0; j<columns; j++){
                 if(grid[i][j] == 1){
                     perimeter = perimeter(i,j);
                     break;
                 } 
             }
         }
 
         return perimeter;
     }
 
     public int perimeter(int pos_a, int pos_b){
         if(pos_a < 0 || pos_a == rows || pos_b < 0 || pos_b == columns) return 1;
         if(grid[pos_a][pos_b] == 0) return 1;
         if(grid[pos_a][pos_b] == 2) return 0;
         grid[pos_a][pos_b] = 2;
 
         int perimeter = 0;
         
         perimeter += perimeter(pos_a-1, pos_b);
         perimeter += perimeter(pos_a, pos_b-1);
         perimeter += perimeter(pos_a+1, pos_b);
         perimeter += perimeter(pos_a, pos_b+1);
 
         return perimeter;
     }
}
