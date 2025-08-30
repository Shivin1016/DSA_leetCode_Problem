class Solution {
    public boolean isValidSudoku(char[][] board) {
         
        //iterate over each row and column
        for(int i = 0 ; i < 9 ; i++){
            Set<Character> st = new HashSet<>(); 
            for(int j = 0 ; j < 9 ; j++){
                //for checking col by making constant to row
                if(board[i][j] == '.') continue;
                if(st.contains(board[i][j])){
                    return false;
                }else{
                    st.add(board[i][j]);
                } 

            }
        }

        for(int j = 0 ; j < 9 ; j++){
            Set<Character> st = new HashSet<>(); 
            for(int i = 0 ; i < 9 ; i++){
                //for checking row by making constant to col
                if(board[i][j] == '.') continue;
                if(st.contains(board[i][j])){
                    return false;
                } else{
                    st.add(board[i][j]);
                }
            }
        }

        //checek for 3 * 3 box
        for(int row = 0 ; row < 9 ; row += 3){
            for(int col = 0 ; col < 9 ; col += 3){
                //each box of 3 * 3
                Set<Character> st = new HashSet<>();
                for(int i = row ; i < row + 3 ; i++){
                    for(int j = col ; j < col + 3 ; j++){
                        if(board[i][j] == '.') continue;

                        if(st.contains(board[i][j])){
                            return false;
                        }else{
                            st.add(board[i][j]);
                        }
                    }
                }
            }
        }

        return true;
    }
}