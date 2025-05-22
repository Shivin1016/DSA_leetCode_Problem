class Solution {
    int[][] t;
    public int minInsertions(String s) {
        int n = s.length();

        t = new int[501][501];
        for(int i = 0 ; i < t.length ; i++){
            Arrays.fill(t[i] , -1);
        }
        return solve(0 , n - 1 , s.toCharArray());
    }

    public int solve(int i , int j , char[] s){
        if(i >= j){
            return 0; //matched all charas
        }
        if(t[i][j] != -1) return t[i][j];

        if(s[i] == s[j]){
            //no insertion takes place
            return t[i][j] = solve(i + 1 , j - 1 ,s);
        }
        //else case either increse i means insert jth characterr at ending of string
        int takeI = 1 + solve(i + 1 , j , s);
        int takeJ = 1 + solve(i , j - 1 , s);

        return t[i][j] = Math.min(takeI , takeJ);
    }
}