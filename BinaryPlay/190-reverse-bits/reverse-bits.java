class Solution {
    public int reverseBits(int n) { 

        int ans = 0;

        // Using extra j
        // int j = 31;
        // for(int i = 0 ; i < 32 ; i++){
        //     int k = (n >> i) & 1;
        //     if(k == 1){
        //         ans = ans + (1 << j);
        //     }
        //     j--;
        // }

        // without extra j
        for(int i = 0 ; i < 32 ; i++){
            ans <<= 1 ; // make space for adding last bit
            ans |= (n & 1); // adding last bit
            n >>= 1 ; //move next
        }

        return ans;
    }
}