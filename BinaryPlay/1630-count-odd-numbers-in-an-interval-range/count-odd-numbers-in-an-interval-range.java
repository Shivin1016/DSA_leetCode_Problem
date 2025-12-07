class Solution {
    public int countOdds(int low, int high) {
        long count = (high - low + 1) ;  // count of numbers
 

        if(low % 2 != 0 && high % 2 != 0) return (int)(count / 2) + 1;

        return (int)(count / 2);
    }
}