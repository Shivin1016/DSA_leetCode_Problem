class Solution {
    public long distributeCandies(int n, int limit) {
        //let take exmple for children 2
        //minimum candy asign to the child1 is (n - limit) because max candy assign to ch2 is limit
        //hence ways = maxCh1 - minCh2 + 1

        long mini = Math.max(0 , n - 2 * limit); // for escape from negstive values
        long maxi = Math.min(n , limit);
        long ways = 0;

        for(long ch1 = mini ; ch1 <= maxi ; ch1++){
            //for next two child
            long N = n - ch1;
            long minCh2 = Math.max(0 , N - limit); //for escape from negstive values
            long maxCh2 = Math.min(N , limit);

            ways += (maxCh2 - minCh2 + 1);
        }
        return ways;
    }
}