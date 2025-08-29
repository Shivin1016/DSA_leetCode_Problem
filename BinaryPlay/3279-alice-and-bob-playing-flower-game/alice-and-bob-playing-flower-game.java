class Solution {
    public long flowerGame(int n, int m) { 
        //alice win when the count of x and y lane flower is odd
        //count od comes when (x -> even and y -> odd) or (x ->odd and y -> even)

        //now probability of x -> even and y -> odd is (n / 2) * (m + 1)/2
        //or x ->odd and y -> even is (n + 1) /2 * (m / 2)
        long p1 = ((long)(n) / 2) * ((long)(m + 1)/2);
        long p2 = ((long)(n + 1) / 2) * ((long)(m)/2);
        return p1 + p2;
    }
}