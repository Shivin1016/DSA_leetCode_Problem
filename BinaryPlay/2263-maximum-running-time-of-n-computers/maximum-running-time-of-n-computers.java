class Solution {
    public boolean possible(int[] batteries , long mid_min , int n){
        long targetMin = mid_min * n;
        long sum = 0;

        for(int i = 0 ; i < batteries.length ; i++){
            sum += Math.min(batteries[i] , mid_min);
            if(sum >= targetMin) return true;
        }
        return false;
    }
    public long maxRunTime(int n, int[] batteries) {
        int m = batteries.length;
        long  minElement = Long.MAX_VALUE; 

        long totalSum = 0;
        for(int min : batteries){
            totalSum += min;
            minElement = Math.min(minElement , min);
        }
        long l = minElement;
        long r = totalSum / n; // divide each barrery time to all the computers
        long res = 0;
        while(l <= r){
            long mid_min = l + (r - l) / 2 ;
            if(possible(batteries , mid_min , n)){
                res = mid_min;
                l = mid_min + 1;
            }else{
                r = mid_min - 1;
            }
        }
        return res;
    }
}