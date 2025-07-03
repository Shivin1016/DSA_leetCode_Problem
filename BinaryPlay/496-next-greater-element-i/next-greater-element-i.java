class Solution {
    public int[] ngel(int[] nums){

        int n = nums.length;
        
        int[] ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n - 1 ; i >= 0 ; i--){

            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.add(i);
        }

        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int[] nger = ngel(nums2); 

        Map<Integer , Integer> mp = new HashMap<>();
        for(int i = 0 ; i < n2 ; i++){
            mp.put(nums2[i] , i);
        }

        int[] idx = new int[n1];

        for(int i = 0 ; i < n1 ; i++){
            idx[i] = mp.get(nums1[i]);
        }

        int[] ans = new int[n1];
        for(int i = 0 ; i < n1 ; i++){
            int k = nger[idx[i]];
            if(k != -1){
                ans[i] = nums2[k];
            }else{
                ans[i] = -1;
            }
        }

        return ans;

    }
}