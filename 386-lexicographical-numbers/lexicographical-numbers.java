class Solution {
    public void solve(int curNum , int limit , List<Integer> result){
        if(curNum > limit){
            return;
        }

        result.add(curNum);

        for(int append = 0 ; append <= 9 ; append++){
            int newNum = curNum * 10 + append;
            solve(newNum , limit , result);
        }
    }
    public List<Integer> lexicalOrder(int n) {

        //appoach 02-> Using recursion (DFS)
        List<Integer> result = new ArrayList<>();
        for(int startNum = 1 ; startNum <= 9 ; startNum++){
            solve(startNum , n , result);
        }
        return result;

        //Approach 01-> Using Extra Space for storing numbers into string
        //Time complexity ->O(n) and Space Complexity -> O(n)
        /*List<String> st = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++){
            st.add(Integer.toString(i));
        }

        Collections.sort(st);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            ans.add(Integer.parseInt(st.get(i)));
        }

        return ans;
        */

    }
}