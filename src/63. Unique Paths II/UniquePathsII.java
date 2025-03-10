public class UniquePathsII {
    /*
     * First try, pretty similar to UniquePaths I, this time i change the
     * condition to check if the cell is an obstacle, if it is, i set it to 0. 
     * if not, i sum the previous cell/cells. DP.
     * 
     * Runtime: 0ms beats 100%
     * Memory: 41.78mb beats 64.18%
     */

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            obstacleGrid[0][0] = (obstacleGrid[0][0] == 0) ? 1 : 0;
    
            for(int i = 1;i<obstacleGrid.length; i++){
                obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) 
                ? 1 : 0;
            }
    
            for(int i = 1;i<obstacleGrid[0].length; i++){
                obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) 
                ? 1 : 0;
            }
    
    
            for(int i = 1; i<obstacleGrid.length; i++){
                for(int j = 1; j<obstacleGrid[0].length; j++){
                    int actual = obstacleGrid[i][j];
    
                    if(actual == 1){
                        obstacleGrid[i][j] = 0;
                        continue;
                    }
    
                    obstacleGrid[i][j] += obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }   
            }
    
            return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
        }
    }
}
