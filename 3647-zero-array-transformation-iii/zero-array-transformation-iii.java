class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int q = queries.length;
        int n = nums.length; 

        Arrays.sort(queries , (a , b) ->Integer.compare(a[0] , b[0]));

        PriorityQueue<Integer> farthestImapct = new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> past = new PriorityQueue<>();
        int j = 0;
        int usedQueries = 0;
        for(int i = 0 ; i < n ; i++){
            while(j < q){
                if(queries[j][0] == i){
                    farthestImapct.add(queries[j][1]);
                }else break;
                j++;
            }

            //check any past queries  
            nums[i] -= past.size();
            //if nums[i] not become zero then check it in farthestImapct
            while(nums[i] > 0 && !farthestImapct.isEmpty() && farthestImapct.peek() >= i){
                int endingIdx = farthestImapct.peek();
                farthestImapct.poll();
                past.add(endingIdx);
                usedQueries++;
                nums[i]--;
            }

            //nums[i] not set zero then return -1
            if(nums[i] > 0) return -1;

            //clear out past indecis which are outdated
            while(!past.isEmpty() && past.peek() <= i){
                past.poll();
            }
        }

        return q - usedQueries;

    }
}