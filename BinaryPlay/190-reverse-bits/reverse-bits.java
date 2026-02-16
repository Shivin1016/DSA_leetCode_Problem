class Solution {
    public int reverseBits(int n) { 

        int ans = 0;
        int j = 31;

        for(int i = 0 ; i < 32 ; i++){
            int k = (n >> i) & 1;
            if(k == 1){
                ans = ans + (1 << j);
            }
            j--;
        }

        return ans;
    }
}