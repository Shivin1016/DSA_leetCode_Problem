class Solution {
    public boolean isPowerOfTwo(int n){

        int count = 0 ;
        if(n < 0){
            return false;
        }

        while(n != 0){
            if( (n&1) == 1 ) count++;
            n = n >> 1;
        }

        return count == 1;

        // for(int i = 0 ; i < 32 ; i++){
        //     double power = Math.pow(2 , i); 
        //     if((double)(n) == power){
        //         return true;
        //     }
        // }

        // return false;
    }
}