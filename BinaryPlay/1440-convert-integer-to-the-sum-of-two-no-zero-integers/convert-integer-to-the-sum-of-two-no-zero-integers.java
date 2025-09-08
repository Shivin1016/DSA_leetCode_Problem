class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a = 1; 
        while(true){
            int b = n - a; 
            if(!Integer.toString(b).contains("0") && !Integer.toString(a).contains("0")){
                return new int[]{b , a};
            }
            a++;
        }
        // return new int[]{};
    }
    // public boolean isbContainsZero(int b){
    //     while(b != 0){
    //         if(b % 10 == 0) return true;
    //         b /= 10;
    //     }
    //     return false;
    // }
}