class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Pair<Integer, Integer>> mp = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] == 0){
                    mp.add(new Pair<>(i, j));
                }
            }
        }

        //now itrate over the map to get row and col which Have zero
        for(Pair<Integer , Integer> pair : mp){
            int row = pair.getKey();
            int col = pair.getValue();
            for(int i = 0 ; i < m ; i++){
                matrix[i][col] = 0;
            } 
            for(int j = 0 ; j < n ; j++){
                matrix[row][j] = 0;
            }
        }
    }
}