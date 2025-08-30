class Solution { 
    public int minCut(String s) {
        int n = s.length();

        int[][] t = new int[n][n]; 

        for(int i = 0 ; i < n ; i++) t[i][i] = 1;

        for(int L = 2 ; L <= n ; L++){
            for(int i = 0 ; i < n - L + 1 ; i++){
                int j = i + L - 1;
                if(s.charAt(i) == s.charAt(j)){
                    if(i + 1 == j){
                        t[i][j] = 1;
                    }else{
                        t[i][j] = (t[i + 1][j - 1] == 1) ? 1 : 0; 
                    }
                }
            }
        }

        //dp[i] => minimum cuts required from string of indices 0 to i into palindroms
        int[] dp = new int[2001]; 

        for(int i = 1 ; i < n ; i++){
            if(t[0][i] == 1) {
                //no cuts required already in palindrom
                dp[i] = 0;
            }else{
                dp[i] = Integer.MAX_VALUE;
                for(int k = 0 ; k < i ; k++){
                    if(t[k + 1][i] == 1 && 1 + dp[k] < dp[i]){
                        dp[i] = 1 + dp[k];
                    }
                }
            }
        }

        return dp[n - 1];
    }  
}