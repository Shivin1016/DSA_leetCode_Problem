class Solution { 
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        
        //approach 
        int x = (int) (Math.log(n) / Math.log(4));

        return n == Math.pow(4 , x);   
    }
}