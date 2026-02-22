class Solution {
    public int binaryGap(int n) { 
        int maxDistance = 0;
        int lastSeen = 0 , first_1 = -1;
        while(n > 0){
            if((n & 1) == 1){
                if(first_1 != -1){
                    int dist = lastSeen - first_1;
                    maxDistance = Math.max(maxDistance , dist);
                }
                first_1 = lastSeen;
            }   
            n >>= 1;
            lastSeen++;
        }

        return maxDistance;
    }
}