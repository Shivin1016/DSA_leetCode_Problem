class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        
        int n = nums.length;

        //for preprocessing -> check that already all numbers are same
        int[] cnt = new int[2];
        for(int num : nums){
            if(num == 1){
                cnt[0]++; // for num == 1
            }else cnt[1]++; // for num == -1
        } 

        //it means the array is already in all equal numbrs
        if((cnt[0] == 0 && cnt[1] != 0) || (cnt[0] != 0 && cnt[1] == 0)){
            return true;
        }

        int[] t = nums.clone(); 
        //for element = 1
        int totalSum1 = check(nums , 1 , n , k);
        // for elemnet = -1
        int totalSum2 = check(t , -1 , n , k); 
        
        if(totalSum1 == n || totalSum2 == -n) return true; 
        
        return false;
        
    }

    public int check(int[] temp ,int key, int n , int op){ 
        
        for(int i = 0 ; i < n - 1 ; i++){

            if(temp[i] == key) continue;

            if(op > 0){ // check till operation remains
                temp[i] = temp[i] * -1;
                temp[i + 1] = temp[i + 1] * -1; 
                op--; 
            }
            else if(op <= 0) break;
        }

        //check is all numbers are equal -> if the sum is equal to the n or -n because there is 1 or -1
        int sum = 0;
        for(int num : temp){
            sum += num;
        } 
        return sum;
    }
}