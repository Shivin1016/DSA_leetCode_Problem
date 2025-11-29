class Solution {
    public int minFlips(int a, int b, int c) {
        int countOp = 0;

        while(a > 0 || b > 0 || c > 0){
            int aBit = a % 2;
            int bBit = b % 2;
            int cBit = c % 2;

            if(cBit == 0){
                countOp += (aBit + bBit);
            }else if(cBit == 1){
                countOp += (aBit == 0 && bBit == 0) ? 1 : 0;
            }

            a /= 2;
            b /= 2;
            c /= 2;
        }

        return countOp;
    }
}