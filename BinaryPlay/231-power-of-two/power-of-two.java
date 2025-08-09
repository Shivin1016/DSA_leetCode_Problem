class Solution {
    public boolean isPowerOfTwo(int n){

        for(int i = 0 ; i < 32 ; i++){

            double power = Math.pow(2 , i); 
            if((double)(n) == power){
                return true;
            }
        }

        return false;
    }
}