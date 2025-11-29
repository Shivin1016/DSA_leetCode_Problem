class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int mask = 0;
        int xor = 0;
        int pos = k - 1; // the position where we need to store one 

        for(int i = 0 ; i < n ; i++){ 
            xor ^= nums[i];
        }
        if(xor == k) return 0;
 
        int countOp =0; 
        mask |= k;
        while(mask > 0 || xor > 0){
            int bit1 = mask % 2;
            int bit2 = xor % 2;

            if(bit1 + bit2 == 1) countOp++;

            mask /= 2;
            xor /= 2;
        }
         
        return countOp;
    }
}