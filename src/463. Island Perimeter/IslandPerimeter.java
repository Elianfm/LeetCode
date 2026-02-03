class IslandPerimeter {


    
    /*
     * Second try, simpler approach
     * Iterate through the grid, when I find a land cell (1)
     * I check its four sides, if it's on the border of the grid
     * or if the adjacent cell is water (0) I add one to the perimeter.
     * 
     * Runtime: 4ms beats 99.81%
     */
    class Solution2 {
        public int islandPerimeter(int[][] grid) {

            int perimeter = 0;
            
            for(int i = 0; i<grid.length; i++){
                for(int j = 0; j<grid[0].length; j++){
                    int actual = grid[i][j];
                    if(actual == 1){
                        if(i == 0 || grid[i-1][j] == 0) perimeter++;
                        if(j == 0 || grid[i][j-1] == 0) perimeter++;

                        if(i == grid.length-1 || grid[i+1][j] == 0) perimeter++;
                        if(j == grid[0].length-1 || grid[i][j+1] == 0) perimeter++;
                    }
                }
            }

            return perimeter;
        }
    }

    class Solution {
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
}
