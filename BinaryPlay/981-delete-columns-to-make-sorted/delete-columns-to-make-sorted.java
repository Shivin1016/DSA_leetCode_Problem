class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length; 
        int col = strs[0].length();

        int count = 0; 

        for(int i = 0 ; i < col ; i++){  // traverse on columns
            for(int j = 1 ; j < row ; j++){ // traverse on rows 
                if(strs[j].charAt(i) < strs[j - 1].charAt(i)){ // if any col found then break
                    count++; //nor sorted 
                    break;
                }
            }
        }

        return count;
        
    }
}