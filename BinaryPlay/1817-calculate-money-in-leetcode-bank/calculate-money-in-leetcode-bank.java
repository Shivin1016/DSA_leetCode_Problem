class Solution {
    public int totalMoney(int n) {
        int day = 1;
        int mon = 1;
        int i = mon;
        int sum = 0;
        while(n-- > 0){
            if(day > 7){
                mon++;
                i = mon;
                day = 1; 
            }
            sum += i;
            i++;
            day++;
        }
        return sum;
    }
}