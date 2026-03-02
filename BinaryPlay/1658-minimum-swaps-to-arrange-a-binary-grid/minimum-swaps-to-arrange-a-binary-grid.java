class Solution {
    private void bubbles(int[] nums , int i , int j){
        for(int k = j ; k > i ; k--){
            int temp = nums[k];
            nums[k] = nums[k - 1];
            nums[k- 1] = temp;
        }
    }
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int steps = 0;

        int[] endZeros = new int[n];

        for(int i = 0 ; i < n ; i++){
            int cnt = 0; // store cnt of zeros from last
            for(int j = n - 1 ; j >= 0 ; j--){
                if(grid[i][j] == 1) break;
                cnt++;
            } 
            endZeros[i] = cnt;
        }

        for(int i = 0 ; i < n ; i++){
            int requiredZeros = n - i - 1;
            boolean findZeros = false;
            for(int j = i ; j < n ; j++){
                if(endZeros[j] >= requiredZeros){
                    steps += (j - i);
                    findZeros = true;
                    bubbles(endZeros , i , j); 
                    break;
                }
            }

            if(!findZeros) return -1;
        }

        return steps;
    }
}