class Solution {
    public int evalRPN(String[] tokens) { 

        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(String str : tokens){ 
            if(!str.equals("*") && !str.equals("/") && !str.equals("+") && !str.equals("-")){
                int num = Integer.valueOf(str);
                st.add(num);
            }else{ 
                int num2 = st.pop();
                int num1 = st.pop();
                if(str.equals("+")){
                    ans = num1 + num2;
                }else if(str.equals("-")){
                    ans = num1 - num2;
                }else if(str.equals("*")){
                    ans = num1 * num2;
                }else if(str.equals("/")){
                    ans = num1 / num2;
                }
                st.add(ans);
            }
        }
        return st.peek();
    }
}