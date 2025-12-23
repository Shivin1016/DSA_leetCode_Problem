class Solution {
    int n ;
    int[][] t ;
    public int solve(int[][] arr , int i , int cnt){
        if(cnt == 2 || i >= n) return 0;

        if(t[i][cnt] != -1) return t[i][cnt];

        int nextValidIdx = binarySearch(arr , arr[i][1]); // so that we found non-overlapp
        int take = arr[i][2] + solve(arr , nextValidIdx , cnt + 1);
        int not_take = solve(arr , i + 1 , cnt);

        return t[i][cnt] = Math.max(take , not_take);
    }
    public int binarySearch(int[][] arr , int endTime){
        int l = 0;
        int r = n - 1;
        int ans = n;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid][0] > endTime){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    public int maxTwoEvents(int[][] events) {
        n = events.length;
        //sort events on basis of starting time
        Arrays.sort(events , (a , b) -> a[0] - b[0]);

        // memoization
        t = new int[n + 1][2];
        for(int[] arr : t){
            Arrays.fill(arr , -1);
        }

        return solve(events , 0 , 0);
    }
}