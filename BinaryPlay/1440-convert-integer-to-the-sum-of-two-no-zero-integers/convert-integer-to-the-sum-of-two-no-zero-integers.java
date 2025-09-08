class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1; 
        while(true){
            int b = n - a;
            if(!isbContainsZero(b) && !isbContainsZero(a)){
                return new int[]{b , a};
            }
            a++;
        }
        // return new int[]{};
    }
    public boolean isbContainsZero(int b){
        while(b != 0){
            if(b % 10 == 0) return true;
            b /= 10;
        }
        return false;
    }
}