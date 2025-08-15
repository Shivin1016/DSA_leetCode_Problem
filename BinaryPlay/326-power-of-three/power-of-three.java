class Solution {
    public boolean check(int n){
        if(n == 0) return false;

        if(n == 1) return true; 

        return n % 3 == 0 && check(n / 3);
    }
    public boolean isPowerOfThree(int n) {

        if(n == 0) return false;

        //Approach 04 -> divide max power of 3 which fit into 32 bit integer by n if it's modulo become zero , return ture

        int pow = (int)Math.pow(3 , 19); // maximum power fit into 32 bit
        return n > 0 && pow % n == 0;

        //using log solution -> basic mathmatics
        /*
          suppose n can be -> 3 ^ x = n -> take log on both side(take base 10) 
          log(3^x) = log(n) -> x = log(n) / log(3) --> if x is integer then return true
        */
        // double x = ((Math.log10(n)) / (Math.log10(3)));
        // return x == (int)x;

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