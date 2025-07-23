class Solution {

    public String removeSubStr(String str , String matchStr){

        Stack<Character> st = new Stack<>();
        int n = str.length();

        for(int i = 0 ; i < n ; i++){
            char ch = str.charAt(i);
            if(ch == matchStr.charAt(1) && !st.empty() && st.peek() == matchStr.charAt(0)){
                st.pop();
            }else{
                st.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.peek());
            st.pop();
        }
        sb.reverse();
        return sb.toString();
    }
    public int maximumGain(String s, int x, int y) {
        int n = s.length();

        int score = 0;
        String maxString = (x >= y) ? "ab" : "ba";
        String minString = (x < y) ? "ab" : "ba"; 

        //first pass is for max point --> for starting string
        String first_pass = removeSubStr(s , maxString);
        int len = first_pass.length();
        int removedChar = n - len; 
        //removed character is maxStr --> so make pair for score 
        score += (removedChar / 2) * Math.max(x , y);
        // System.out.println(maxString);

        //second pass is for min point --> remaining string-->after deleting first pass string
        System.out.println(first_pass + " " + minString);
        String second_pass = removeSubStr(first_pass , minString);
        int remainLen = second_pass.length();
        removedChar = len - remainLen ;
        score += (removedChar / 2) * Math.min(x , y);
        // System.out.println(score + " " + remainLen);

        return score;
    }
}