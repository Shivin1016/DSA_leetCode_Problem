class Solution {
    public int lower_bound(int[] potions , long target , long spell , int m){
        int l = 0;
        int r = m - 1;
        int res = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            long prod = potions[mid] * spell;
            if(prod >= target){
                res = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return res;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        Arrays.sort(potions);
        int[] pairs = new int[n];

        for(int i = 0 ; i < n ; i++){
            int idx = lower_bound(potions , success , spells[i] , m); 
            pairs[i] = m - (idx == -1 ? m : idx);
        }

        return pairs;
    } 
}