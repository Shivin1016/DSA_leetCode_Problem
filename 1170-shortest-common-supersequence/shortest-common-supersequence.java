class Solution { 

    public String shortestCommonSupersequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length(); 

        int[][] t = new int[1001][1001];
        for(int i = 0 ; i < n1 + 1 ; i++){

            for(int j = 0 ; j < n2 + 1 ; j++){

                if(i == 0 || j == 0){
                    t[i][j] = i + j;
                }
                else if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    t[i][j] = 1 + t[i - 1][j - 1];
                }else{
                    t[i][j] = 1 + Math.min(t[i-1][j] , t[i][j - 1]);
                }
            }
        }

        String ans = "";
        int i = n1 , j = n2;
        while(i > 0 && j > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
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

        System.out.println(i +" " + j);

        while(i > 0){
            ans = str1.charAt(i - 1) + ans;
            i--;
        }

        while(j > 0){
            ans = str2.charAt(j - 1) + ans;
            j--;
        }

        return ans;

    }

    
}