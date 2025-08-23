class Solution { 
    public int minArea(int startRow , int endRow , int startCol , int endCol , int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int upperMostRow = m;
        int bottomMostRow = -1;
        int leftMostCol = n;
        int rightMostCol = -1;

        for(int i = startRow ; i < endRow ; i++){
            for(int j = startCol ; j < endCol ; j++){

                if(grid[i][j] == 1){
                    //width
                    upperMostRow = Math.min(upperMostRow , i);
                    bottomMostRow = Math.max(bottomMostRow , i);

                    //length
                    leftMostCol = Math.min(leftMostCol , j);
                    rightMostCol = Math.max(rightMostCol , j);
                }

            }
        }
        int width = bottomMostRow - upperMostRow + 1;
        int lenght = rightMostCol - leftMostCol + 1;

        return width * lenght;
    }
    public int minimumSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
 

        int[][] rotateGrid = new int[n][m]; //rotate anticlockwise
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                rotateGrid[n - j - 1][i] = grid[i][j];
            }
        }

        //for case 1 , case 2 and case3
        int result = solve1(grid); 

        //case 1 , case 2 and case3 for rotategrid 
        result = Math.min(result , solve1(rotateGrid));
 

        return result;
    }

    public int solve1(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int res = Integer.MAX_VALUE;

        for(int rowSplit = 1 ; rowSplit < m ; rowSplit++){
            for(int colSplit = 1 ; colSplit < n ; colSplit++){
                //top grid
                int top = minArea(0 , rowSplit , 0 , n , grid);
                //bottomleft
                int bottomLeft = minArea(rowSplit , m , 0 , colSplit , grid);
                //bottom right
                int bottomRight = minArea(rowSplit , m , colSplit , n , grid);

                res = Math.min(res , (top + bottomLeft + bottomRight));

                //topLeft
                int topLeft = minArea(0 , rowSplit , 0 , colSplit , grid);
                //top right
                int topRight = minArea(0 , rowSplit , colSplit , n , grid);
                //bottom
                int bottom = minArea(rowSplit , m , 0 , n , grid);

                res = Math.min(res , (topLeft + topRight + bottom));

            }
        }

        for(int rowSplit1 = 1 ; rowSplit1 < m ; rowSplit1++){
            for(int rowSplit2 = rowSplit1 + 1 ; rowSplit2 < m ; rowSplit2++){
                //top
                int top = minArea(0 , rowSplit1 , 0 , n , grid);
                //mid
                int mid = minArea(rowSplit1 , rowSplit2 , 0 , n , grid);
                //bottom
                int bottom = minArea(rowSplit2 , m , 0 , n , grid);

                res = Math.min(res , (top + mid + bottom));
            }
        }

        return res;

    }  
}