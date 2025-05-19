class Solution {
    int n1 , n2;
    int[][] t ;
    public int minDistance(String word1, String word2) {
        n1 = word1.length();
        n2 = word2.length();

        //memoiazation
        // t = new int[501][501];
        // for(int i = 0 ; i < t.length ; i++){
        //     Arrays.fill(t[i] , -1);
        // }

        //bottom Up Approach->
        t = new int[n1 + 1][n2 + 1];

        for(int i = 0 ; i <= n1 ; i++){
            for(int j = 0 ; j <= n2 ; j++){
                if(i == 0 || j == 0){
                    t[i][j] = i + j;
                }
                else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    t[i][j] = t[i - 1][j - 1];
                }
                else{
                    int ins = 1 + t[i][j - 1]; //insertion
                    int del = 1 + t[i - 1][j]; // deletion
                    int rep = 1 + t[i - 1][j - 1]; // replace
                    t[i][j] = Math.min(ins , Math.min(del , rep));
                }
            }
        }
        return t[n1][n2];

        //start from left to right
        // return solve(0 , 0 , word1.toCharArray() , word2.toCharArray());
        //start from right to left
        // return solve(n1, n2 , word1.toCharArray() , word2.toCharArray());

    }

    

    public int solve(int i , int j , char[] s1 , char[] s2){

        if(i <= 0 && j <= 0) return 0;

        if(t[i][j] != -1) return t[i][j];

        // if(i <= 0 && j > 0){
        //     return t[i][j] = j;
        // }
        // if(i > 0 && j <= 0){
        //     return t[i][j] = i;
        // }
        //shorter way ro right above conditons case
        if(i == 0 || j == 0) return t[i][j] = i + j;

        //character are already equal then no operation to be performed
        if(s1[i - 1] == s2[j - 1]){
            return t[i][j] = solve(i - 1 , j - 1 , s1 , s2);
        }

        //other wise we have to do three operations
        //insert --> only jth pointer will move forward
        int ins = 1 + solve(i , j - 1 , s1 , s2);

        //deletion --> only ith pointer will move forward
        int del = 1 + solve(i - 1 , j , s1 ,s2);

        //replace--> both character move forward
        int rep = 1 + solve(i - 1 , j - 1 , s1 , s2);

        return t[i][j] = Math.min(ins , Math.min(del , rep));
    }

    //start from left to right
    // public int solve(int i , int j , char[] s1 , char[] s2){

    //     if(i >= n1 && j >= n2) return 0;

    //     if(t[i][j] != -1) return t[i][j];

    //     if(i >= n1 && j < n2){
    //         return t[i][j] = (n2 - j);
    //     }
    //     if(i < n1 && j >= n2){
    //         return t[i][j] = (n1 - i);
    //     }

    //     //character are already equal then no operation to be performed
    //     if(s1[i] == s2[j]){
    //         return t[i][j] = solve(i + 1 , j + 1 , s1 , s2);
    //     }

    //     //other wise we have to do three operations
    //     //insert --> only jth pointer will move forward
    //     int ins = 1 + solve(i , j + 1 , s1 , s2);

    //     //deletion --> only ith pointer will move forward
    //     int del = 1 + solve(i + 1 , j , s1 ,s2);

    //     //replace--> both character move forward
    //     int rep = 1 + solve(i + 1 , j + 1 , s1 , s2);

    //     return t[i][j] = Math.min(ins , Math.min(del , rep));
    // }
}