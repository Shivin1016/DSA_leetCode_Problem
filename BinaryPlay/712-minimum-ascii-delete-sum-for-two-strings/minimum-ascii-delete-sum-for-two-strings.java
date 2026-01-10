class Solution {
    int m , n ;
    int[][] t ;
    private int solve(char[] s1 , char[] s2 , int i , int j){
        if(i == m && j == n){
            return 0;
        }
        // delete chars from jth to n - 1
        if(i == m && j < n){
            return (int)s2[j] + solve(s1 , s2 , i , j + 1);
        }

        // delete chars from ith to m - 1
        if(i < m && j == n){
            return (int)s1[i] + solve(s1 , s2 , i + 1 , j);
        }

        if(t[i][j] != -1) return t[i][j];

        int delete_i = 0;
        int delete_j = 0;
        if(s1[i] == s2[j]){
            return t[i][j] = solve(s1 , s2 , i + 1 ,j + 1);
        }
        else{
            delete_i = (int)s1[i] + solve(s1 , s2 , i + 1 , j);
            delete_j = (int)s2[j] + solve(s1 , s2 , i , j + 1);
        }

        return t[i][j] = Math.min(delete_i , delete_j);
    }
    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        t = new int[m][n];
        for(int[] r : t){
            Arrays.fill(r , - 1);
        }

        return solve(s1.toCharArray() , s2.toCharArray() , 0 , 0);
    }
}