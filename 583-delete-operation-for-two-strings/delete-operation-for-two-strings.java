class Solution {
    int[][] memo;
    int n , m;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        memo = new int[501][501];
        for(int[] t : memo){
            Arrays.fill(t , -1);
        }

        return solve(0 , 0 , word1.toCharArray() , word2.toCharArray());
    }

    public int solve(int i , int j , char[] s1 , char[] s2){
        if(i >= m && j >= n){
            return 0;
        } 

        if(i >= m && j < n){
            return 1 + solve(i , j + 1 , s1 , s2);
        }

        if(i < m && j >= n){
            return 1 + solve(i + 1 , j , s1 , s2);
        }

        if(memo[i][j] != -1) return memo[i][j];

        if(s1[i] == s2[j]) return solve(i + 1 , j + 1 , s1 ,s2);

        int step1 = 1 + solve(i + 1 , j , s1 , s2);
        int step2 = 1 + solve(i , j + 1 , s1 ,s2);

        return memo[i][j] = Math.min(step1 , step2);
    }
}