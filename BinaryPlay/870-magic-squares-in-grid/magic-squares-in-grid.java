class Solution {
    public boolean isMagicGrid(int[][] grid , int row , int col){
        // check for unique elements and must be between 0 to 9
        Set<Integer> st = new HashSet<>();

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        
        for(int i = row ; i < row + 3 ; i++){
            for(int j = col ; j < col + 3 ; j++){
                if(grid[i][j] < 1 || grid[i][j] > 9) return false;

                if(st.contains(grid[i][j])) return false;
                st.add(grid[i][j]);
            } 
        }

        for(int i = 0 ; i < 3 ; i++){ 
            diagonalSum1 += grid[row + i][col + i]; // topLeft to bottmRight diagonal
            diagonalSum2 += grid[row + i][col + 2 - i]; // topRight to bottomLeft diagonal
        }

        // as all rows , cols amd diagonal sum must be same for magic grid
        if(diagonalSum1 != diagonalSum2) return false;

        //from now doigonals sum are same
        
        int rowSum = 0;
        int colSum = 0;

        // rowWise first row sum 
        for(int i = col ; i < col + 3 ; i++){
            rowSum += grid[row][i];
        }

        // colwise first col sum 
        for(int i = row ; i < row + 3 ; i++){
            colSum += grid[i][col];
        }

        if(rowSum != colSum) return false;

        // check for all rowsSum  
        for(int i = row + 1 ; i < row + 3 ; i++){
            int currSum = 0;
            for(int j = col ; j < col + 3 ; j++){
                currSum += grid[i][j];
            }
            if(currSum != rowSum) return false;
        }

        // check for all colsSum
        for(int j = col + 1 ; j < col + 3 ; j++){
            int currSum = 0;
            for(int i = row ; i < row + 3 ; i++){
                currSum += grid[i][j];
            }
            if(currSum != colSum) return false;
        }

        // colSum and rwoSum

        return diagonalSum1 == rowSum;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for(int i = 0 ; i < row - 3 + 1 ; i++){
            for(int j = 0 ; j < col - 3 + 1 ; j++){
                if(isMagicGrid(grid , i , j)) count++;
            }
        }

        return count;
    }
}