class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        String ans = "";
        int[][] t = new int[m + 1][n + 1];

        for(int i = 0 ; i < m + 1 ; i++){
            for(int j = 0 ; j < n + 1 ; j++){
                if(i == 0 || j == 0){
                    t[i][j] = i + j;
                }else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    t[i][j] = 1 + t[i - 1][j - 1];
                }else{
                    t[i][j] = 1 + Math.min(t[i - 1][j] , t[i][j - 1]);
                }
            }
        }

        int i = m , j = n; 
        while(i > 0 || j > 0){

            if(i == 0 && j > 0){
                ans = str2.charAt(j - 1) + ans;
                j--;
            }

            else if(i > 0 && j == 0){
                ans = str1.charAt(i - 1) + ans;
                i--;
            }

            else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                ans = str1.charAt(i - 1) + ans;
                i--;
                j--;
            }else{
                if(t[i - 1][j] < t[i][j - 1]){
                    ans = str1.charAt(i - 1) + ans;
                    i--;
                }else{
                    ans = str2.charAt(j - 1) + ans;
                    j--;
                }
            }
        }
 

        return ans;
    }
}