class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        // sorted[i] = true, means strs[i] < strs[i+1] is already fixed
        boolean[] sorted = new boolean[rows-1];
        int ans = 0;

        for(int col=0; col<cols; col++) {
            boolean needDelete = false;

            for(int row=0; row<rows-1; row++) {
                if(!sorted[row] && strs[row].charAt(col) > strs[row+1].charAt(col)) {
                    needDelete = true;
                    break;
                }
            }

            if(needDelete) {
                ans++;
                continue;  // skip updating sorted[], move to next column
            }

            // Update sorted pairs where this column fixes order
            for(int row=0; row<rows-1; row++) {
                if(!sorted[row] && strs[row].charAt(col) < strs[row+1].charAt(col)) {
                    sorted[row] = true;
                }
            }
        }

        return ans;
    }
} 