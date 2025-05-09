class Solution {
    int n ;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        //LIS code Approach ->It gives us TLE 
        // List<Integer> ans = new ArrayList<>();

        // solve(0 , nums , ans , new ArrayList<>() , -1);
        // return ans;

        //using bottom up approach of lIS
        int[] t = new int[n]; 
        Arrays.fill(t , 1);

        int[] prev_Idx = new int[n];
        Arrays.fill(prev_Idx , -1);
        int maxL = 1;
        int last_idx_choosen = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(t[i] < t[j] + 1){
                        t[i] = t[j] + 1; 
                        prev_Idx[i] = j;
                    } 
                    if(t[i] > maxL){
                        maxL = t[i];
                        last_idx_choosen = i;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();  
        while(last_idx_choosen >= 0){
            ans.add(nums[last_idx_choosen]); 
            last_idx_choosen = prev_Idx[last_idx_choosen];
        }

        return ans;
    }

    public void solve(int idx , int[] nums , List<Integer> ans , List<Integer> temp , int prev){
        if(idx >= n){
            if(ans.size() < temp.size()){
                ans.clear();
                ans.addAll(temp);
            }
            return;
        }

        //Take
        if(prev == -1 || (nums[idx] % nums[prev]) == 0){
            temp.add(nums[idx]); //Take
            solve(idx + 1 , nums , ans , temp , idx);
            temp.remove(temp.size() - 1); //notTake
        }

        //notTake
        solve(idx + 1 , nums , ans , temp , prev);
    }
}