class Solution {
    public boolean check(int n){
        if(n == 0) return false;

        if(n == 1) return true;

        if(n % 3 != 0) return false;

        return check(n / 3);
    }
    public boolean isPowerOfThree(int n) {

        //recusive solution
        return check(n);

        //iterative solution
        /*if(n == 0) return false;

        while(n % 3 == 0){
            n /= 3;
        }

        return n == 1;
        */
    }
}