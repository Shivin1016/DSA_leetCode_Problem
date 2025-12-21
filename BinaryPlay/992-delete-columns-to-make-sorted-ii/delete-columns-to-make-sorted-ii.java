class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        // sorted[i] = true, means strs[i] < strs[i+1] is already fixed
        boolean[] alreadySorted = new boolean[rows-1];
        int deletion = 0;

        for(int col = 0 ; col < cols; col++) {
            boolean canDelete = false;

            for(int row = 0 ; row < rows - 1 ; row++) {
                if(!alreadySorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)){
                    canDelete = true;
                    deletion++;
                    break;
                }
            }

            if(canDelete) { 
                continue;  // skip updating sorted[], move to next column
            }

            // Update sorted pairs where this column fixes order
            for(int row= 0 ; row < rows-1 ; row++) {
                // if(!alreadySorted[row] && strs[row].charAt(col) < strs[row + 1].charAt(col)) {
                // }
                    alreadySorted[row] = alreadySorted[row] | strs[row].charAt(col) < strs[row + 1].charAt(col);
            }
        }

        return deletion;
    }
} 