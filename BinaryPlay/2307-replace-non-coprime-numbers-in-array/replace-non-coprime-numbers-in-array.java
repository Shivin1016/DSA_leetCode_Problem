class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {

        int n = nums.length; 

        List<Integer> ans = new ArrayList<>();  
        for(int num : nums){
            while(ans.size() > 0){
                int size = ans.size();
                int prev = ans.get(size - 1);
                int curr = num;
                int gcd = solve(prev , curr);
                if(gcd == 1){
                    break;
                }
                //merge
                ans.remove(size - 1);
                int LCM = prev / gcd * curr; 
                num = LCM;
            }
            ans.add(num);
        } 
        return ans;
    }
    public int solve(int a , int b){
        if(b == 0){
            return a;
        }

        return solve(b , a % b);
    }
}