class Solution {
    int[][] t;
    public int countSubstrings(String s) {

        int n = s.length();

        int count = 0;
        t = new int[n + 1][n + 1];
        for(int[] r : t){
            Arrays.fill(r , -1);
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                if(checkPlaindrom(i , j , s.toCharArray()) == 1){
                    count++;
                }
            }
        }

        return count;
    }

    public int checkPlaindrom(int i , int j , char[] s){
        if(i > j){
            return 1;
        }
        if(t[i][j] != -1) return t[i][j];

        if(s[i] == s[j]){
            return t[i][j] = checkPlaindrom(i + 1 , j - 1 , s);
        }
        return t[i][j] = 0;
    }
}