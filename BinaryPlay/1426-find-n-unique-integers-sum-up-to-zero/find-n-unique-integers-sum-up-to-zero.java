class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];

        int num = 1;
        int i = 0;
        while(i < n){
            if(i == n - 1){
                ans[i++] = 0;
            }else{
                ans[i++] = num;
                ans[i++] = -num;
            } 
            num++;
        }
        return ans;
    }
}