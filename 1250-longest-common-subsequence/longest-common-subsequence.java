class Solution {
    int n1 , n2;
    int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();

        //Approach 01--> recursion and memoization 
        t = new int[1001][1001]; // memoization 
        for(int i = 0 ; i < t.length ; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(0 , 0 , text1.toCharArray() , text2.toCharArray());
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