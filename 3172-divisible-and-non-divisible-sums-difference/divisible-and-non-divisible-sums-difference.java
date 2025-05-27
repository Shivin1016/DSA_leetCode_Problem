class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for(int num = 1 ; num <= n ; num++){
            if(num % m != 0){
                num1 += num;
            }else{
                num2 += num;
            }
        }
        return num1 - num2;
    }

    // 1 2 3 4 5 6 7 8 9 10 --> (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 3
}