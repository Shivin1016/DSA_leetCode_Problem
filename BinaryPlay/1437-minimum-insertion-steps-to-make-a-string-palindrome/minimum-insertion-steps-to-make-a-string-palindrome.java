class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        int[][] t = new int[501][501]; 

        //t[i][j] --> minimum operatio to make palindrom of string from i to j

        for(int L = 1 ; L <= n ; L++){
            for(int i = 0 ; i < n - L + 1 ; i++){
                int j = i + L - 1;

                if(i == j) t[i][j] = 0;

                else if(s.charAt(i) == s.charAt(j)){
                    t[i][j] = t[i + 1][j - 1];
                }else{
                    t[i][j] = 1 + Math.min(t[i][j - 1] , t[i + 1][j]);
                }
            }
        }

        return t[0][n - 1]; // minimum number of operation neended to make string palin from 0 to n- 1
 
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