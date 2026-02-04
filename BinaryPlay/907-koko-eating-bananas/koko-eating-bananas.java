class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int maxK = piles[0];
        for(int i = 1 ; i < n ; i++){
            maxK = Math.max(maxK , piles[i]);
        }

        if(h == n) return maxK;
        int minK = 1;
        while(minK <= maxK){
            int k = minK + (maxK - minK) / 2;
            long times = 0; // how much time koko come to eats banana(total hour per pile)
            for(int banana : piles){
                // take round to nearest integer of (banana / k) -> that is ceil value -> (banana + k  - 1) /k
                times += (banana + k - 1) / k;
                if(times > h) break;
            }

            if(times <= h){
                // agar time hour se kam aya mtlb aur piche jakr dekho
                maxK = k - 1;
            }else{
                // agar time hour se jada aya mtlb ange jakr dekho
                minK = k + 1;
            }  

        }
        return minK;
    }
}