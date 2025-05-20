class Solution {
    int[][] t;
    public String longestPalindrome(String s) {
        //brute force approach
        int n = s.length();

        //TLE --> Because O(n^3) solution -> brute Force solution
         // int start = 0 , end = 0;
        // int maxLen = 0;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i ; j < n ; j++){
        //         if(isPalindrom(i , j , s.toCharArray())){
        //             if(maxLen < j - i + 1){
        //                 maxLen = j - i + 1;
        //                 start = i;
        //                 end = j;
        //             }
        //         }
        //     }
        // }

        // String ans = "";
        // while(start <= end){
        //     ans += s.charAt(start);
        //     start++;
        // }
        // return ans;

        //better approach using memoization
        // t = new int[1001][1001];
        // for(int i = 0 ; i < t.length ; i++){
        //     Arrays.fill(t[i] , -1);
        // }

        // int maxLen = Integer.MIN_VALUE; 
        // int start = 0 , end = 0;
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i ; j < n ; j++){
        //         if(isPalindrom(i , j , s.toCharArray()) == 1){
        //             if(maxLen < j - i + 1){
        //                 maxLen = j - i + 1;
        //                 start = i;
        //                 end = j;
        //             }
        //         }
        //     }
        // } 

        //Using Bottom Up Approach
        t = new int[1001][1001];
        for(int i = 0 ; i < t.length ; i++){
            Arrays.fill(t[i] , -1);
        }

        int maxLen = Integer.MIN_VALUE; 
        int start = 0 , end = 0;
        for(int L = 1 ; L <= n ; L++){
            for(int i = 0 ; i + L - 1 < n ; i++){
                int j = i + L - 1;
                if(i == j){
                    //for length 1
                    t[i][j]= 1;
                }
                else if(i + 1 == j){
                    t[i][j] = (s.charAt(i) == s.charAt(j)) ? 1 : 0;
                }else{
                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1] == 1) ? 1 : 0;
                }

                if(t[i][j] == 1 && maxLen < j - i + 1){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        String ans = s.substring(start , start + maxLen);
        return ans;

    }

    public int isPalindrom(int i , int j , char[] s){
       if(i >= j){
            return 1;
       }

       if(t[i][j] != -1) return t[i][j];

       if(s[i] == s[j]){
            return t[i][j] = isPalindrom(i + 1 , j - 1 , s);
       }

       return t[i][j] = 0;
    }
}