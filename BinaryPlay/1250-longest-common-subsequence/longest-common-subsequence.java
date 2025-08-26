class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length();
        int n2 = text2.length();

        int[][] t = new int[n1 + 1][n2 + 1];
        //t[i][j] -->Longest common subsequence between s1 of length i and s2 of length j

        for(int i = n1 - 1 ; i >= 0 ; i--){ 

            for(int j = n2 - 1 ; j >= 0 ; j--){

                if(text1.charAt(i) == text2.charAt(j)){
                    t[i][j] = 1 + t[i + 1][j + 1];
                }
                else{
                    t[i][j] = Math.max(t[i + 1][j] , t[i][j + 1]);
                }
            }
        }
        return t[0][0];
    }
}