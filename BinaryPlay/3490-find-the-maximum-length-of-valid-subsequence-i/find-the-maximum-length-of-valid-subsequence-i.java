class Solution { 
    public int maximumLength(int[] nums) {

        int n = nums.length;

        //if (sub[0] + sub[1]) % 2 == 0 --> both can be even or odd number
        //if (sub[0] + sub[1]) % 2 == 1 --> one can be odd or other even or vice versa

        //for long subsequence valid
        //we can pick all even numbers that % 2 == 0
        //we can pick all odd numbers that % 2 == 0
        //we can pick alternative even odd that % 2 == 1

        int oddCnt = 0; // count odd number
        int evenCnt = 0 , alterCnt = 1;
        int parity = nums[0] % 2;

        for(int i = 0 ; i < n ; i++){

            int mod = nums[i] % 2;

            if(mod == 0){
                evenCnt++; //we can pick all even numbers that % 2 == 0
            }
            else{
                oddCnt++; //we can pick all odd numbers that % 2 == 0
            }

            if(i > 0 && mod == 1 - parity){
                alterCnt++;//we can pick alternative even odd that % 2 == 1
                parity = 1 - parity;
            }
        }

        return Math.max(alterCnt , Math.max(evenCnt , oddCnt)); 
    } 
}