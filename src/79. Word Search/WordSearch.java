class WordSearch {
    /* 
     * First try, i use DFS to solve this problem. At first i use Deque to store
     * the path of the word. But i got TLE. I changed to boolean[][] array but i 
     * realized that i can just store the visited cells in the board itself.
     * Runtime 119ms Beats 92.64%
     * Memory 41.48MB Beats 97.70%
     */

     char[][] board;
     String word;
     int wordLen;
     int rows;
     int columns;
     
     public boolean exist(char[][] board, String word) {
         this.board = board;
         this.word =  word;
         this.wordLen = word.length();
         this.rows = board.length;
         this.columns = board[0].length;
 
         for(int i = 0; i<rows; i++){
             for(int j = 0; j<columns; j++){
                 if(word.charAt(0) == board[i][j] && search(i,j,0)) return true;
             }
         }
         
         return false;
     }
 
     public boolean search(int row, int column, int deep){
         if(wordLen == deep) return true;
         if(row<0 || row == rows || column < 0 || column == columns
         || word.charAt(deep) != board[row][column])
             return false;
         
         char temp = board[row][column];
         board[row][column] = '*';  
 
         int nextDepth = deep+1;
         
         if(search(row+1, column, nextDepth) 
         || search(row, column+1, nextDepth) 
         || search(row-1, column, nextDepth)
         || search(row, column-1, nextDepth))
             return true;
         
         board[row][column] = temp;
         return false;
     }

}
