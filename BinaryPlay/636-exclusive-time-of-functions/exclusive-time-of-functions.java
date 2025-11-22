class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int len = logs.size();

        int[] ans = new int[n];
        int prev = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0 ; i < len ; i++){
            String[] log = logs.get(i).split(":");
            int id = Integer.parseInt(log[0]);
            String timeStamp = log[1];
            int time = Integer.parseInt(log[2]);

            if(timeStamp.equals("start")){
                if(!st.isEmpty()){
                    ans[st.peek()] += time - prev;
                }
                st.add(id);
                prev = time;
            }else{
                ans[st.pop()] += time - prev + 1;
                prev = time + 1;
            }
        }
        return ans;
    }
}