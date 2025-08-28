class Solution {
    int m , n;
    int[][] t;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        t = new int[501][501];
        for(int[] r : t){
            Arrays.fill(r , -1);
        }

        return solve(m , n , word1.toCharArray() , word2.toCharArray());
    }

    public int solve(int i , int j , char[] s1 , char[] s2){

        if(i <= 0 && j <= 0){
            return 0;
        }

        if(t[i][j] != -1) return t[i][j];

        if(i > 0 && j == 0){
            return t[i][j] = i;
        }
        if(i == 0 && j > 0){
            return t[i][j] = j;
        }

        if(s1[i - 1] == s2[j - 1]){
            return t[i][j] = solve(i - 1 , j - 1 , s1 , s2);
        }

        //insert
        int insert = 1 + solve(i , j - 1 , s1 , s2);

        //replcae
        int replace = 1 + solve(i - 1 , j - 1 , s1 , s2);

        // delete
        int delete = 1 + solve(i - 1  , j , s1  , s2);

        return t[i][j] = Math.min(insert , Math.min(replace , delete ));

    }
}