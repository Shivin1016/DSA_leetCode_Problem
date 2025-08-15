class Solution { 
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;
        
        //using basic mathmatics approach
        double x = Math.log(n) / Math.log(4); 
        return x == (int)x ;
    }
}