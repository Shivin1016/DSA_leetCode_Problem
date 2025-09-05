class Solution {
    int n ; 
    int[][] t;
    public int solve(int i , int[] jd , int d){ 

        if(d == 1){
            int maxD = jd[i];
            for(int idx = i ; idx < n ; idx++){
                maxD = Math.max(maxD , jd[idx]);
            }
            return maxD; // max difficulty on that day
        }

        if(t[i][d] != -1) return t[i][d];

        int finalResult = Integer.MAX_VALUE;
        int maxD = Integer.MIN_VALUE;
        int result = 0;
        for(int idx = i ; idx <= n - d ; idx++){
            maxD = Math.max(maxD , jd[idx]);

            result = maxD + solve(idx + 1 , jd , d - 1);

            finalResult = Math.min(finalResult , result);
        }

        return t[i][d] = finalResult;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        n = jobDifficulty.length; 

        if(n < d) return -1; // lesser job and more days to solve job

        t = new int[301][11];
        for(int[] r : t) Arrays.fill(r , -1);

        return solve(0 , jobDifficulty , d);
    }
}