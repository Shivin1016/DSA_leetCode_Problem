class Spreadsheet {
    int[][] matrix ;
    public Spreadsheet(int rows) {
        matrix = new int[rows + 1][26];
    }
    
    public void setCell(String cell, int value) {
        //formate is "AX"
        int col = cell.charAt(0) - 'A';

        String rowContent = cell.substring(1 , cell.length());
        int row = Integer.parseInt(rowContent);

        matrix[row][col] = value;
    }
    
    public void resetCell(String cell) {
        setCell(cell , 0); //reset to zero
    }
    
    public int getValue(String formula) {
        // "=X+Y"
        int plusIndex = formula.indexOf('+');

        String left = formula.substring(1 , plusIndex);
        String right = formula.substring(plusIndex + 1 , formula.length()); 

        int c1 = 0 , r1 = 0 , num1 = 0; //left
        if(formula.charAt(1) >= 'A' && formula.charAt(1) <= 'Z'){
            c1 = formula.charAt(1) - 'A';
            r1 = solve(formula.substring(2 , plusIndex)); //row 
            num1 = matrix[r1][c1];
        }else{
            num1 = solve(left); //integer present
        }
        int c2 = 0 , r2 = 0 , num2  = 0; //right
        if(formula.charAt(plusIndex + 1) >= 'A' && formula.charAt(plusIndex + 1) <= 'Z'){
            c2 = formula.charAt(plusIndex + 1) - 'A';
            r2 = solve(formula.substring(plusIndex + 2 , formula.length())); //row 
            num2 = matrix[r2][c2];
        }else{
            num2 = solve(right);  //cells coordinates are present
        }

        return num1 + num2;
    }

    public int solve(String cell){  
        int row = Integer.parseInt(cell);

        return row; //can be or number
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */