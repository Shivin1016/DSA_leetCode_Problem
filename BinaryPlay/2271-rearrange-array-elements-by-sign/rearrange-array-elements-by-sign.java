class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;
        Queue<Integer> que1 = new LinkedList<>(); // plus
        Queue<Integer> que2 = new LinkedList<>(); //minus

        for(int num : nums){
            if(num > 0){
                que1.add(num);
            }else{
                que2.add(num);
            }
        }

        int[] ans = new int[n];
        int i =0 ;
        while(!que1.isEmpty() && !que2.isEmpty()){
            int first = que1.poll();
            int second = que2.poll();

            ans[i++] = first;
            ans[i++] = second;
        }

        return ans;

        /* [3,1,-2,-5,2,-4]
            3 ,1,2
            -2,-5,-4  

        */
    }
}