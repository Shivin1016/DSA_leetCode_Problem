class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        //bottom up approach
        int count = 0;
        int[][] t = new int[1001][1001];
        
        for(int l = 1 ; l <= n ; l++){ //define length for substring
            //iterate over each valid substring of length 'L'
            for(int i = 0 ; i + l - 1 < n ; i++){
                int j = i + l - 1; // valid j
                if(i == j){
                    //one length substring
                    t[i][i] = 1;
                }
                else if(j == i + 1){
                    //two length substring
                    if(s.charAt(i) == s.charAt(j)){
                        t[i][j] = 1;
                    }
                }else{
                    //genric part length greater than 2
                    //substring of length l -> if first char and last char equal then check the substring between them is plaindrom or not
                    if(s.charAt(i) == s.charAt(j) && t[i + 1][j - 1] == 1){
                        t[i][j] = 1;
                    }
                }
                if(t[i][j] == 1){
                    count++; // found plaindrom substring of length L 
                }
            }
        }
        return count;
    }
}