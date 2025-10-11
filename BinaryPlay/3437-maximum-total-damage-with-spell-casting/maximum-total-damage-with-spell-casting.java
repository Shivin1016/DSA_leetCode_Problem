class Solution {
    long maxLen = Integer.MIN_VALUE;
    long[] dp ;
    public long maximumTotalDamage(int[] power) {
        int n = power.length;

        //store frq
        Map<Long , Long> frq = new HashMap<>();
        for(long p : power){
            frq.put(p , frq.getOrDefault(p , (long)0) + (long)1);
        }

        //sort
        Arrays.sort(power); //--> we can only consider the next Power[i] + 3 , don't take power[i] +1  , power[i] + 2 

        //removes duplicate 
        List<Long> temp = new ArrayList<>();
        temp.add((long)power[0]);
        for(int i = 1 ; i < n ; i++){
            if(power[i] == power[i - 1]) continue;
            else temp.add((long)power[i]);
        }

        int[] lower_bound = new int[temp.size()];
        for(int i = 0 ; i < temp.size() ; i++){
            lower_bound[i] = lowerBound(temp , temp.get(i) + 3 , 0 , temp.size() - 1);
        }
        
        dp = new long[n + 1];
        Arrays.fill(dp , -1);

        return solve(temp , 0 , lower_bound , frq);
    }
    public long solve(List<Long> temp , int i , int[] lower_bound , Map<Long , Long> frq){
        if(i >= temp.size()){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        long take = temp.get(i) * frq.get(temp.get(i)) + solve(temp , lower_bound[i] , lower_bound , frq);
        long skip = solve(temp , i + 1 , lower_bound , frq);

        long len = Math.max(take , skip);
        maxLen = Math.max(maxLen , len);
        return dp[i] = maxLen;
    }
    public int lowerBound(List<Long> temp , long target , int l , int r ){
        int res = r + 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(temp.get(mid) >= target){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;
    } 
}