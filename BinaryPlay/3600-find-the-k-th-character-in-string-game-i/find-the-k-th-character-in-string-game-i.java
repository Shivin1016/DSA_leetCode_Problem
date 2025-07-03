class Solution {
    public char kthCharacter(int k) {
        List<Character> ans = new ArrayList<>();
        ans.add('a');

        int n = ans.size();
        while(n < k){

            for(int i = 0 ; i < n ; i++){
                char ch = ans.get(i);
                ch = (char)((ch + 1));
                ans.add(ch);
            }

            n = ans.size();

        }

        return ans.get(k - 1);
    }
}