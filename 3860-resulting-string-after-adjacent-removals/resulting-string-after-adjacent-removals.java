class Solution {
    public String resultingString(String s) {
        int n = s.length();

        //initilize an empty stack
        Stack<Character> st = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && isConsecutive(ch , st.peek())){
                st.pop();
            }else{
                st.add(ch);
            }
        }

        //return the remaining elements of stack 
        StringBuilder ans = new StringBuilder(); // efficent way to insert or delete opration didn't give tle
        while(!st.isEmpty()){
             ans.insert(0 , st.pop()); //efficent way
        }
        return ans.toString();
    }

    public boolean isConsecutive(char ch , char top){
        int diff = Math.abs(ch - top);
        return diff == 1 || diff == 25;
    }
}