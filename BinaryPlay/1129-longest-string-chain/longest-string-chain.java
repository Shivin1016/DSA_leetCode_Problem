class Solution {
    int n ;
    int[][] dp;
    public boolean checkPredcessor(String s1 , String s2){
        int n1 = s1.length(); //curr
        int n2 = s2.length(); // prev

        if(n2 >= n1 || n1 - n2 != 1) return false;
        int i = 0 , j = 0;
        while(i < n1 && j < n2){
            if(s1.charAt(i) == s2.charAt(j)){
                j++;
            }
            i++;
        }
        return j == n2;
    }
    public int longestStrChain(String[] words) {

        n = words.length;
        Arrays.sort(words , (a, b) -> a.length() - b.length());

        dp = new int[n+ 1][n + 1];
        for(int i = 0 ; i <= n ;i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(words , 0 , -1);
    }

    public int solve(String[] words , int i , int prev){
        if(i >= n) return 0;
 
        if(prev != -1 && dp[i][prev] != -1) return dp[i][prev];

        int take = 0;
        if(prev == -1 || checkPredcessor(words[i] , words[prev])){
            take = 1 + solve(words , i + 1 , i);
        }

        int skip = solve(words , i + 1 , prev);

        if(prev != -1){
            dp[i][prev] = Math.max(take , skip);
        }
        return Math.max(take , skip);
    }
}