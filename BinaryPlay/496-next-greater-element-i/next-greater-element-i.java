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
        // for(int i = 0 ; i < n2 ; i++){
        //     System.out.println(nger[i]);
        // }

        int[] idx = new int[n1];

        for(int i = 0 ; i < n1 ; i++){
            for(int j = 0 ; j < n2 ; j++){
                if(nums1[i] == nums2[j]){
                    idx[i] = j;
                    break;
                }
            }
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