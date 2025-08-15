class Solution {
    public boolean check(int n){
        if(n == 0) return false;

        if(n == 1) return true;

        if(n % 4 != 0) return false;

        return check(n / 4);
    }
    public boolean isPowerOfFour(int n) {

        //recursive solution
        return check(n);
       
       //itrative solution
        /*if(n == 0) return false;

        while(n % 4 == 0){
            n /= 4;
        }

        return n == 1;
        */
    }
}