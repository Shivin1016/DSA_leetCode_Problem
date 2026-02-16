class Solution {
    public int reverseBits(int n) { 

        int ans = 0;
        int j = 30;

        for(int i = 0 ; i < 32 ; i++){
            int k = (n >> i) & 1;
            if(k == 1){
                if(j == -1){
                    ans = ans + (int)Math.pow(2 , 0);
                }else{
                    ans = ans + (2 << j);
                }
            }
            j--;
        }

        return ans;
    }
}