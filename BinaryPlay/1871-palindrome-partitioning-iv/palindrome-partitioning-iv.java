class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();

        int[][] t = new int[n][n];

        for (int i = 0; i < n; i++) {
            //palindromic substring for length l = 1
            t[i][i] = 1;
        }

        //for L >= 2
        for (int L = 2; L < n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (i + 1 == j) {
                        //for two length
                        t[i][j] = 1;
                    } else {
                        //greter then 2
                        t[i][j] = (t[i + 1][j - 1] == 1) ? 1 : 0;
                    }
                }
            }
        } 

        //As we have required just two cuts 
        //check it using pointers i to j --> start , mid and end
        for(int i = 0 ; i < n - 2 ; i++){
            for(int j = n - 1 ; j >= 2 ; j--){
                int firstStr = t[0][i];
                int midStr = t[i + 1][j - 1];
                int endStr = t[j][n - 1];
                if(firstStr == 1 && midStr == 1 && endStr == 1){
                    return true;
                }
            }
        }

        return false;
    }
}