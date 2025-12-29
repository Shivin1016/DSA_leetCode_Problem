class Solution {
    public boolean solve(StringBuilder curr_bottom  , StringBuilder next_above ,Map<String , List<Character>> left_right_and_top , int i){
        if(curr_bottom.length() == 1) return true;

        if(i == curr_bottom.length() - 1){
            return solve(next_above , new StringBuilder() ,left_right_and_top  , 0);
        }

        String pair = curr_bottom.substring(i , i + 2);
        if(!left_right_and_top.containsKey(pair)){
            return false;
        }
        for(char ch : left_right_and_top.get(pair)){
            next_above.append(ch);
            if(solve(curr_bottom , next_above , left_right_and_top , i + 1) == true){
                return true;
            }
            next_above.deleteCharAt(next_above.length() - 1);
        }

        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) { 

        // put all bottom string chars in a list
        StringBuilder curr_bottom = new StringBuilder();
        for(char ch : bottom.toCharArray()){
            curr_bottom.append(ch);
        }

        Map<String , List<Character>> left_right_and_top = new HashMap<>();

        for(String st : allowed){
            String left_right = st.substring(0 , 2);
            char top = st.charAt(2);

            left_right_and_top.computeIfAbsent(left_right , k -> new ArrayList<>()).add(top);
        } 

        StringBuilder next_above = new StringBuilder();

        return solve(curr_bottom , next_above , left_right_and_top , 0);

    }
}