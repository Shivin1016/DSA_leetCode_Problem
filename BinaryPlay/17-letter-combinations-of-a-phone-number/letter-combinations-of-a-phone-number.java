class Solution {
    int n;
    public void solve(String digits , String[] map , int idx , StringBuilder op , List<String> ans){
        if(idx >= n){
            ans.add(op.toString());
            return ;
        }

        int number = digits.charAt(idx) - '0';
        String value = map[number];
        for(int i = 0 ; i < value.length() ; i++){
            op.append(value.charAt(i));
            solve(digits , map , idx + 1 , op , ans);
            op.deleteCharAt(op.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;

        n = digits.length(); 
        int idx = 0;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        solve(digits , map , idx , new StringBuilder() , ans);

        return ans;
    }
}