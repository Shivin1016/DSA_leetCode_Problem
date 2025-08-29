class Solution {
    int[][] t;
    public int longestPalindromeSubseq(String s) {
        int n  =s.length();
        t = new int[1001][1001];
        for(int[] r : t) Arrays.fill(r , -1);
        return solve(0 , n - 1 , s.toCharArray());
    }

    public int solve(int i , int j , char[] s){
        if(i > j){
            return 0;
        }

        if(i == j) return 1;

        if(t[i][j] != -1) return t[i][j];

        if(s[i] == s[j]){
            return t[i][j] = 2 + solve(i + 1 , j - 1 , s);
        }
        
        return t[i][j] = Math.max(solve(i + 1 , j , s) , solve(i , j - 1 , s));
    }
}