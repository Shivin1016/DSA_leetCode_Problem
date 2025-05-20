class Solution {
    int n;
    int[][] memo;
    public int longestPalindromeSubseq(String s) { 
        n = s.length();

        //using recursion and memoo
        // memo = new int[1001][1001];
        // for(int i = 0 ; i < memo.length ; i++){
        //     Arrays.fill(memo[i] , - 1);
        // }
        // return solve(0 , n - 1 , s.toCharArray());

        //using bottom Up Approach
        int[][] t = new int[1001][1001];
        for(int i = 0 ; i < t.length ; i++){
            t[i][i] = 1; // for length one subsequnce always palindrom
        }
        //now for length greater than 2
        for(int l = 2 ; l <= n ; l++){
            for(int i = 0 ; i < n - l + 1 ; i++){
                int j = l + i - 1;
                if(s.charAt(i) == s.charAt(j)){
                    t[i][j] = 2 + t[i + 1][j - 1];
                }else{
                    t[i][j] = Math.max(t[i][j - 1] , t[i + 1][j]);
                }
            }
        }
        return t[0][n - 1]; // longest subsequnce form( 0 to n - 1) length

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