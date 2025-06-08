class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<String> st = new ArrayList<>();

        for(int i = 1 ; i <= n ; i++){
            st.add(Integer.toString(i));
        }

        Collections.sort(st);

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            ans.add(Integer.parseInt(st.get(i)));
        }

        return ans;
    }
}