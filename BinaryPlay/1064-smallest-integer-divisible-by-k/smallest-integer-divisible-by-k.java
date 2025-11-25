class Solution {
    // 1111 / 4 ==> never gives you 0 reminder 
    public int smallestRepunitDivByK(int k) {
        if(k == 1) return 1; // base 1 

        //jo even number hai unko return kar do -1  or any number that multiple of 5 or 5 
        if(k % 2 == 0 || k % 5 == 0) return -1;

        //jo remaing number  3 , 7 , 9 and uske multiples hai   

        int rem = 0;  
        int count = 0; // size of the number which contains only 1 digit 
        while(count <= k){ //count goes greater then k then we could not found that number 
            count++; 
            rem = ((rem * 10) + 1 ) % k; 
            if(rem == 0){
                return count; // size of the number which contains only 1 digit
            }
        }
 

        return -1;
    }
}