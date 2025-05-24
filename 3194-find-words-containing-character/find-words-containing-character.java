class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        int n = words.length;

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){ 
            String st = words[i];
            for(char ch : st.toCharArray()){
                if(ch == x){
                    ans.add(i);
                    break;
                }
            }
        }
        return ans;
    }
}