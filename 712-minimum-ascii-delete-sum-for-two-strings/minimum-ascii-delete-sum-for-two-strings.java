class Solution {
    int n ,m;
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {
        // brute force approach
        if(s1.equals(s2)) return 0;

        n = s1.length();
        m = s2.length(); 

        memo = new int[1001][1001];
        for(int i = 0 ; i < 1001 ; i++){
            Arrays.fill(memo[i] , -1);  
        }

        return solve(0 , 0 , s1.toCharArray() , s2.toCharArray());
    }

    public int solve(int i , int j , char[] s1 , char[] s2){
        if(i == n && j == m){
            return 0; // both string got empty
        }

        if(memo[i][j] != -1) return memo[i][j];

        if(i >= n){
            return s2[j] + solve(i , j + 1 , s1 , s2); 
        }
        if(j >= m){
            return s1[i] + solve(i + 1 , j , s1 , s2);
        }

        if(s1[i]== s2[j]) return solve(i + 1 ,j +1 , s1 ,s2);

        int res1 = 0 , res2 = 0;

        res1 =  s1[i] + solve(i + 1 , j , s1 , s2);
        res2 =  s2[j] + solve(i , j + 1, s1 , s2);
            

        return memo[i][j] = Math.min(res1 , res2);
    }
}