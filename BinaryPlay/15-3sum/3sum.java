class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        if(n < 3) return ans;

        Arrays.sort(nums); // as the elements returns not idx

        // find two elem(n1 , n2) whose sum is equal to the -(n1); which means all three will give us 0 on summation 

        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue; // bcz same element gives duplicates
            
            int target = -(nums[i]);
            int j = i + 1 , k = n - 1; //apply two sum approach

            while(j < k){ 
                int sum = nums[j] + nums[k];
                if(sum == target){
                    // first remove duplicates 
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    List<Integer> temp = List.of(-target , nums[j] , nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                }else if(sum < target) j++;
                else k--;
            }
        }


        return ans;

    }
}
