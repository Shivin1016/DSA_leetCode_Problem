class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int lenght = 0; 
        int height = 0;

        //store leftMost col and rightMost col -->width
        //store upperMost row and bottomMost row -->height
        int leftMost = -1 , rightMost = -1;
        int upperMost = -1 , bottomMost = -1;
        for(int i = 0 ; i < m ; i++){

            for(int j = 0 ; j < n ; j++){

                if(grid[i][j] == 1){
                    //for height
                    if(upperMost == -1){
                        upperMost = i;
                    }
                    bottomMost = i;
                    
                    //fot width
                    if(leftMost == -1){
                        leftMost = j;
                        rightMost = j;
                    }else{
                        leftMost = Math.min(leftMost , j);
                        rightMost = Math.max(rightMost , j);
                    }

                }
            }  
        }
        //if any one of -1 then return 0
        if(upperMost != -1 && bottomMost != -1 && leftMost != -1 && rightMost != -1){
            height = bottomMost - upperMost + 1;
            lenght = rightMost - leftMost + 1;
        }
            
        return height * lenght;
    }
}