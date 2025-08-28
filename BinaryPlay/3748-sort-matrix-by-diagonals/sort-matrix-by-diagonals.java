class Solution {
    int m , n;
    public List<Integer> sortDiagonal(int i , int j , int[][] grid){
        List<Integer> temp = new ArrayList<>();

        while(i < m && j < n){
            temp.add(grid[i][j]);
            i++;
            j++;
        }
        Collections.sort(temp);
        return temp;
    }
    public int[][] sortMatrix(int[][] grid) {

        m = grid.length;
        n = grid[0].length;
  
        //bottom-left diagonal -->Dcreasing order
        for(int i = 0 ; i < m ; i++){
            int rowStart = i;
            int colStart = 0;

            List<Integer> tempSort = sortDiagonal(rowStart , colStart , grid);
            Collections.reverse(tempSort);
            while(rowStart < m && colStart < n){
                grid[rowStart][colStart] = tempSort.get(colStart);
                rowStart++;
                colStart++;
            }
        } 

        //Top-right diagonal -->Increasing order
        for(int j = 1 ; j < n ; j++){
            int rowStart = 0;
            int colStart = j;

            List<Integer> tempSort = sortDiagonal(rowStart , colStart , grid);
            int idx = 0;
            while(rowStart < m && colStart < n){
                grid[rowStart][colStart] = tempSort.get(idx++);
                rowStart++;
                colStart++;
            }
        } 


        return grid;
    }
}