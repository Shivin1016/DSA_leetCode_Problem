class Solution {
    int n;
    int[][] memo;
    public int longestPalindromeSubseq(String s) { 
        n = s.length();

        memo = new int[1001][1001];
        for(int i = 0 ; i < memo.length ; i++){
            Arrays.fill(memo[i] , - 1);
        }

        return solve(0 , n - 1 , s.toCharArray());
    }

    public int solve(int i , int j , char[] s){
        //if i goes greater than j
        if(i > j) return 0;

        //control repeatative terms
        if(memo[i][j] != -1) return memo[i][j]; 

        //char at i and j equals
        if(s[i] == s[j]){
            if(i != j)
            {
                return memo[i][j] = 2 + solve(i + 1 , j - 1 , s);
            }else{
                //both i and j have equal index so same char
                return memo[i][j] = 1 + solve(i + 1 , j - 1 , s);
            }
        }
        //if not equal return max of both
        return memo[i][j] = Math.max(solve(i , j - 1 , s) , solve(i + 1 , j , s));
    }
}