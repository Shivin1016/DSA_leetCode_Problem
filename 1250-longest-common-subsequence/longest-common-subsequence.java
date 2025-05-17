class Solution {
    int n1 , n2;
    int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();

        //Approach 01--> recursion and memoization 
        // t = new int[1001][1001]; // memoization 
        // for(int i = 0 ; i < t.length ; i++){
        //     Arrays.fill(t[i] , -1);
        // }

        // return solve(0 , 0 , text1.toCharArray() , text2.toCharArray());
        //bottom up aprroach
        t = new int[n1 + 1][n2 + 1];
        // t[i][j] --> state defined that LCS between s1 of length i and s2 of length j
        
        for(int i = 1 ; i < n1 + 1 ; i++){
            for(int j = 1 ; j < n2 + 1 ; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    t[i][j] = 1 + t[i - 1][j - 1];
                }else{
                    t[i][j] = Math.max(t[i][j - 1] , t[i - 1][j]);
                }
            }
        }

        return t[n1][n2];
    }

    public int solve(int i , int j , char[] text1 , char[] text2){
        //base case if any one of the array becomes empty then return 0
        if(i >= n1 || j >= n2) return 0;

        if(t[i][j] != -1) return t[i][j];

        //both character are same then add one
        if(text1[i] == text2[j]){
            return t[i][j] = 1 + solve(i + 1 , j + 1 , text1 , text2);
        }

        int takeS1 = solve(i , j + 1 , text1 , text2);
        int takeS2 = solve(i + 1 , j , text1 , text2);
        
        return t[i][j] = Math.max(takeS1 , takeS2);

    }
}