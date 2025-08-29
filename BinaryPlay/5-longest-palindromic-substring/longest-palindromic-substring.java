class Solution { 
    public String longestPalindrome(String s) {
        int n = s.length();

        int[][] t = new int[1001][1001]; 

        int maxLen = Integer.MIN_VALUE;
        int sp = 0; // starting point

        for(int L = 1 ; L <= n ; L++){
            for(int i = 0 ; i + L - 1 < n ; i++){
                int j = i + L - 1;
                if(i == j){ 
                    t[i][j] = 1;
                }else if(i + 1 == j){
                    t[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
                }else{
                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1] == 1) ? 1 : 0;
                }

                if(t[i][j] == 1){
                    if(maxLen < j - i + 1){
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }
        System.out.println(sp + " "+ maxLen);
        return s.substring(sp , maxLen + sp);
    }
}