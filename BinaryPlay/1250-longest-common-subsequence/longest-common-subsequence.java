class Solution {
    int n1 , n2 ;
    int[][] t;
    public int longestCommonSubsequence(String text1, String text2) {
        n1 = text1.length();
        n2 = text2.length();

        t = new int[1001][1001];
        for(int[] row : t) Arrays.fill(row , -1);

        return solve(0 , 0 , text1.toCharArray() , text2.toCharArray());
    }
    public int solve(int i , int j , char[] s1 , char[] s2){

        if(i >= n1 || j >= n2){
            return 0;
        }

        if(t[i][j] != -1) return t[i][j];

        if(s1[i] == s2[j]){
            return t[i][j] = 1 + solve(i + 1 , j + 1 , s1 , s2);
        }
        else{
            return t[i][j] = Math.max(solve(i + 1 , j , s1 , s2) , solve(i , j + 1 , s1 , s2));
        }
    }
}