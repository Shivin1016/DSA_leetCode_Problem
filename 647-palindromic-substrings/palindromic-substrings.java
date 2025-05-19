class Solution {
    public int palinCount(String s , int left ,  int right ){ 
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)){
            count++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int n = s.length(); 
        int ans = 0;

        // for(int i = 0 ; i < n ; i++){ 
        //     int evenCount = palinCount(s , i , i + 1);
        //     int oddCount = palinCount(s , i - 1 , i + 1);
        //     ans += evenCount + oddCount + 1;
        // }

        // return ans;

        //BruteForce approach
        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i ; j < n ; j++){
        //         if(isPalinDrom(i , j , s.toCharArray())){
        //             ans++;
        //         }
        //     }
        // }
        
        //memoization in brute force approach
        int[][] t = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(t[i] , -1);
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(isPalinDrom(i , j , s.toCharArray() , t) == 1){
                    ans++;
                }
            }
        }
        return ans;
    }

    public int isPalinDrom(int i , int j , char[] s , int[][] t){

        if(i >= j) return 1; // all characters were seen from start to end

        if(t[i][j] != -1) return t[i][j];

        if(s[i] == s[j]){
            return t[i][j] = isPalinDrom(i + 1 , j - 1 , s , t);  
        }

        return 0;
    }
}