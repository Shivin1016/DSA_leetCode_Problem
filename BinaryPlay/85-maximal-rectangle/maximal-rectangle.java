class Solution { 
    private int[] nextSmallarElement(int[] heights , int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i = n - 1 ; i >= 0 ; i--){
            int curr = heights[i];
            while(st.peek() != -1 && heights[st.peek()] >= curr){
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    private int[] prevSmallarElement(int[] heights , int n){
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for(int i =0 ; i < n ; i++){
            int curr = heights[i];
            while(st.peek() != -1 && heights[st.peek()] >= curr){
                st.pop();
            }
            ans[i] = st.peek();
            st.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] next = new int[n];
        next = nextSmallarElement(heights,n);

        int[] prev = new int[n];
        prev = prevSmallarElement(heights,n);
        int area = 0;

        for(int i = 0 ; i < n ; i++){
            int l = heights[i];

            if(next[i] == -1){
                next[i] = n;
            }
            int b = next[i] - prev[i] -1;

            int newArea = l * b;
            area = Math.max(area,newArea);
        }
        return area;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] prefixSum = new int[n][m];

        // prefiSum 2d
        for(int j = 0 ; j < m ; j++){
            int sum = 0;
            for(int i = 0 ; i < n ; i++){
                sum += matrix[i][j] - '0';
                if(matrix[i][j] == '0') sum = 0;
                prefixSum[i][j] = sum;
            }
        }

        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            maxArea = Math.max(maxArea ,largestRectangleArea(prefixSum[i]));
        }

        return maxArea;
    }
}                                                                                                                                                                                                                                                                                                                                    