class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        int[][] t = new int[501][501];
        for(int[] r : t){
            Arrays.fill(r , -1);
        }

        return solve(0 , n - 1 , s.toCharArray() , t);
    }

    public int solve(int i , int j , char[] s , int[][] t){
        if(i > j) return 0;

        if(t[i][j] != -1) return t[i][j];

        if(i == j) return 0;

        if(s[i] == s[j]){
            return t[i][j] = solve(i + 1 , j - 1 , s , t);
        } 

        return t[i][j] = 1 + Math.min(solve(i , j - 1 , s , t) , solve(i + 1 , j , s , t));
    }
}