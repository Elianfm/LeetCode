public class RottingOranges {

    /*
     * First try, a bit verbose, i use a recursive approach, exploring all the possible combinations of the grid, 
     * and checking if the actual orange is rotten, if it is, i can skip it, if it isn't, i have to add the minute to the result.
     * I also use a memoization grid to avoid exploring the same orange multiple times.
     * 
     * Runtime: 2ms beats 91.05%
     */
    class Solution {
        int[][] grid;
        int[][] minutes;

        public int orangesRotting(int[][] grid) {
            this.grid = grid;
            this.minutes = new int[grid.length][grid[0].length];
        
            for(int i = 0; i<minutes.length; i++)
                Arrays.fill(minutes[i],-1);

            List<Pos> pos = new ArrayList<>();
            for(int i = 0; i<grid.length; i++){
                for(int j = 0; j<grid[0].length; j++){
                    if(grid[i][j] == 2){
                        minutes[i][j] = 0;
                        pos.add(new Pos(i,j));
                    }
                }
            }

            for(Pos p: pos){
                rotting(p.row+1, p.col,1);
                rotting(p.row-1, p.col,1);
                rotting(p.row, p.col+1,1);
                rotting(p.row, p.col-1,1);
            }

            int min = 0;
            for(int i = 0; i<minutes.length; i++){
                for(int j = 0; j<minutes[0].length; j++){
                    if(grid[i][j] == 1 && minutes[i][j] == -1) return -1;
                    min = Math.max(min, minutes[i][j]);
                }
            }

            return min;
            
        }

        private void rotting(int row, int col, int minute){
            if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) return;

            if(grid[row][col] != 1 || minutes[row][col] != -1 && minutes[row][col] <= minute) return;

            minutes[row][col] = minute;

            rotting(row+1, col, minute+1);
            rotting(row, col+1, minute+1);
            rotting(row-1, col, minute+1);
            rotting(row, col-1, minute+1);
        }

        private class Pos{
            int row;
            int col;

            public Pos(int row, int col){
                this.row = row;
                this.col = col;
            }
        }
    }
}
