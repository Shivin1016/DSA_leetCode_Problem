class Solution {
    int n;
    int[][] memo;
    public int maxValue(int[][] events, int k) {

        n = events.length;

        //Sort on the basis of start Day
        Arrays.sort(events , (a, b) -> Integer.compare(a[0] , b[0]));

        //take and skip wali approach --> DP
        memo = new int[n + 1][k + 1];
        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(memo[i] , -1);
        }

        return solve(events , 0 , k); // 0 is starting index

    }

    public int solve(int[][] events , int idx , int k){
        if(idx >= n || k == 0){
            return 0;
        }

        if(memo[idx][k] != -1){
            return memo[idx][k];
        }

        //skip the event
        int skip = solve(events , idx + 1 , k);

        //take the event
        int j = idx + 1; 
        //using linear seach 
        for( ; j < n ; j++){
            if(events[j][0] > events[idx][1]){
                break;
            }
        }
        int take = events[idx][2] + solve(events , j , k - 1);

        return memo[idx][k] = Math.max(skip , take);
    }
}