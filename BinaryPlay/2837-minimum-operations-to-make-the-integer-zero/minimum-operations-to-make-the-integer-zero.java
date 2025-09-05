class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        long t = 1;
        while(true){
            long val = num1 - (long)(t * num2);
            if(val < 0){
                return -1;
            }
            long min_bit = Long.bitCount(val);
            if(min_bit <= t && t <= val){
                return (int)t;
            }
            t++;
        } 
    }
}