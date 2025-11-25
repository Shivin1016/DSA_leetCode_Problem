class Solution {
    public int smallestRepunitDivByK(int k) {
        if(k == 1) return 1;
        //jo even number hai unko return kar do -1
        if(k % 2 == 0 || k % 5 == 0) return -1;

        //jo remaing 3 , 7 , 9 and uske multiples hai  

        int rem = 0;
        int count = 0;
        while(count <= k){ //count goes greater then k then we could not found that number 
            count++;
            rem = ((rem * 10) + 1 ) % k;
            if(rem == 0){
                return count;
            }
        }
 

        return -1;
    }
}