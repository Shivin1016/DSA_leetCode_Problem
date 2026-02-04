class MinStack { 
    Stack<Integer> st; 
    int minVal = Integer.MAX_VALUE;

    public MinStack() {
        st = new Stack<>(); 
    }
    
    public void push(int val) { 
        if(val <= minVal){
            st.add(minVal); //pahele old minimum
            minVal = val;
        }
        st.add(val);  
    }
    
    public void pop() {
        if(st.pop() == minVal) minVal = st.pop();
    }
    
    public int top() {
        int peek = st.peek(); 
        return peek;
    }
    
    public int getMin() {
        return minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */