class Solution {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int operation = 0; 

        int prev = -1;
        int curr = 0;
        while(curr < n){
            int ab1 = Math.abs(target[curr]);
            int ab2 = 0;
            if(prev == -1) ab2 = 0;
            else ab2 = Math.abs(target[prev]);

            if(ab1 > ab2){
                operation += (ab1 - ab2);
            }
            prev = curr;
            curr++;
        }

        return operation;
    }
}