class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for(int i = 0 ; i < ans.length ; i++){ 
            ans[i] = solve(nums , i , i + k - 1 , x); 
        }
        return ans;
    }
    public int solve(int[] nums , int start , int end , int x){
        Map<Integer , Integer> mp = new HashMap<>();
        while(start <= end){
            mp.put(nums[start] , mp.getOrDefault(nums[start] , 0) + 1);
            start++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int num : mp.keySet()){
            int frq = mp.get(num);
            pq.add(new int[]{frq , num});

            while(pq.size() > x){
                pq.poll();
            }
        }
        int sum = 0; 
        while(!pq.isEmpty()){
            int[] p = pq.poll(); 
            sum += (p[1] * p[0]);
        }
        return sum;
    }
}