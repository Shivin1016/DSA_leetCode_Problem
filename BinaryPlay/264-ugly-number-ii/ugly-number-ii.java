class Solution {
    public int nthUglyNumber(int n) {
        int[] t = new int[n + 1];
        //t[i] --> stores ith ugly number
        //return t[n] --> nth ugly number

        //t[1] --> is already an ugly number
        t[1] = 1;
        int i2 , i3 , i5;
        i2 = i3 = i5 = 1;

        for(int i = 2 ; i <= n ; i++){

            int i2UglyNumber = t[i2] * 2;
            int i3UglyNumber = t[i3] * 3;
            int i5UglyNumber = t[i5] * 5;

            int minUglyNumber = Math.min(i2UglyNumber , Math.min(i3UglyNumber , i5UglyNumber));

            //find ith ugly numer
            t[i] = minUglyNumber;

            //increase pointers if they equal to minUglyNumbers
            if(minUglyNumber == i2UglyNumber){
                i2++;
            }
            if(minUglyNumber == i3UglyNumber){
                i3++;
            }
            if(minUglyNumber == i5UglyNumber){
                i5++;
            }
        }

        return t[n];
    }
}