public class UniquePathsII {

    /*
     * Same as second try, but in-place, using the input first row grid as DP, 
     * instead of creating a new array to store the paths. So, is O(1) space 
     * instead of O(n) but modifies original input, which is not ideal, but 
     * works for this problem
     * 
     * Runtime 0ms beats 100%
     */

    class Solution3 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {        
            obstacleGrid[0][0] = Math.abs(obstacleGrid[0][0]-1);

            for(int i = 0; i<obstacleGrid.length; i++){
                for(int j = 0; j<obstacleGrid[0].length; j++){
                    if((i != 0 || j != 0) && obstacleGrid[i][j] == 1){
                        obstacleGrid[0][j] = 0;
                        continue;
                    }
                    if(j > 0) obstacleGrid[0][j] += obstacleGrid[0][j-1];
                }
            }

            return obstacleGrid[0][obstacleGrid[0].length-1];
        }
    }

    /*
     * Second try, cleaner code, instead of using the input grid as dp, 
     * i create a new array to store the paths (DP) and i "reset" the paths
     *  to 0 when i find an obstacle, otherwise, i sum the previous cell/cells. DP.
     * 
     * Runtime 0ms beats 100%
     */

    class Solution2 {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int[] paths = new int[obstacleGrid[0].length];
            
            paths[0] = Math.abs(obstacleGrid[0][0]-1);

            for(int i = 0; i<obstacleGrid.length; i++){
                for(int j = 0; j<obstacleGrid[0].length; j++){
                    if(j > 0) paths[j] += paths[j-1];
                    if(obstacleGrid[i][j] == 1) paths[j] = 0;
                }
            }

            return paths[paths.length-1];
        }
    }


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
