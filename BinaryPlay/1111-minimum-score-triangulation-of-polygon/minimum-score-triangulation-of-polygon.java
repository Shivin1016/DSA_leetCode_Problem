class Solution { 
    int[][] t;
    public int solve(int[] values , int i , int j){
        //we need atleast three points to amke a triangle
        if(j - i + 1 < 3) return 0;

        if(t[i][j] != -1) return t[i][j];

        int result = Integer.MAX_VALUE;
        for(int k = i + 1 ; k < j ; k++){
            int weight = values[i] * values[j] * values[k] + solve(values , i , k) + solve(values , k , j);
            t[i][j] = Math.min(result , weight);
            result = Math.min(result , weight);
        }

        return result;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        t = new int[51][51];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(values , 0 , n - 1);
    }
}