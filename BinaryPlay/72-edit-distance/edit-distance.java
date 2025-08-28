class Solution {
    int m , n; 
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        //bottom up
        int[][] t = new int[m + 1][n + 1]; 
        // t[i][j] -- > number of operation needed if s2 has length i and s2 has lenght j

        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(i == 0 || j== 0){
                    t[i][j] = i + j;
                }
                else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    t[i][j] = t[i - 1][j - 1];
                }else{
                    t[i][j] = 1 + Math.min(t[i - 1][j - 1] , Math.min(t[i][j - 1] , t[i - 1][j]));
                }
            }
        }

        return t[m][n];
    }
 
}