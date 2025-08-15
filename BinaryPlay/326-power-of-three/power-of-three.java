class Solution {
    public boolean check(int n){
        if(n == 0) return false;

        if(n == 1) return true; 

        return n % 3 == 0 && check(n / 3);
    }
    public boolean isPowerOfThree(int n) {

        if(n == 0) return false;

        //using log solution -> basic mathmatics
        /*
          suppose n can be -> 3 ^ x = n -> take log on both side 
          log(3^x) = log(n) -> x = log(n) / log(3) --> if x is integer then return true
        */

        double x = ((Math.log10(n)) / (Math.log10(3)));
        return x == (int)x;

        //recusive solution
        // return check(n);

        //iterative solution
        /*if(n == 0) return false;

        while(n % 3 == 0){
            n /= 3;
        }

        return n == 1;
        */
    }
}