

import java.util.ArrayList;
import java.util.List;

/* PENDING TO REFACTOR */
class SpiralMatrix {


    /*
     * First try, i remember how snake game works and i tried to implement
     * the same logic to solve this problem. Anyways this is just a draft
     * i have to refactor this code to make it more readable and clean
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 41.41 Beats 79.19%
     */

     public List<Integer> spiralOrder(int[][] matrix) {
        /* Indicates the direction
        * 1 - Right
        * 2 - Down
        * 3 - Left
        * 4 - Up
        */
        int direction = 1;

        List<Integer> spiral = new ArrayList<>();

        List<Integer> visited_row = new ArrayList<>();
        List<Integer> visited_column = new ArrayList<>();

        int row = 0;
        int column = 0;

        int row_size = matrix.length-1;
        int column_size = matrix[0].length-1;


        while(true){
            
            spiral.add(matrix[row][column]);

            switch(direction){
                case 1: //right
                    column++;

                    if(column>column_size || visited_column.contains(column)){
                        column--;
                        direction = 2;
                        visited_row.add(row++);
                    }

                    break;
                case 2: // down
                    row++;

                    if(row>row_size || visited_row.contains(row)){
                        row--;
                        direction = 3;
                        visited_column.add(column--);
                    }

                    break;
                case 3: // left
                    column--;

                    if(column<0 || visited_column.contains(column)){
                        column++;
                        direction = 4;
                        visited_row.add(row--);
                    }

                    break;
                case 4: //up
                    row--;

                    if(row>row_size || visited_row.contains(row)){
                        row++;
                        direction = 1;
                        visited_column.add(column++);
                    }

                    break;
            }

            if(visited_row.contains(row) || visited_column.contains(column)
            || row > row_size || row < 0 || column > column_size || column < 0)
                break;



        }
        
        return spiral;

    }
}
