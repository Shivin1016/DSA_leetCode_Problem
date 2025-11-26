class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        //number setBits in xor 
        return Integer.bitCount(xor);
    }
}