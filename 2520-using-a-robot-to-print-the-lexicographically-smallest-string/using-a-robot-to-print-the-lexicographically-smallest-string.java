class Solution {
    public String robotWithString(String s) {
        // int n = s.length();

        // //find minCHarTOright using preprocessing to right
        // char[] minCharToRight = new char[n];
        // char minCharIdx = s.charAt(n - 1);
        // for(int i = n - 1 ; i >= 0 ; i--){
        //     if(s.charAt(i) < minCharToRight.charAt()){
        //         minCharIdx = i;
        //         minCharToRight[i] = minCharIdx;
        //     }else{
        //         minCharToRight[i] = minCharIdx;
        //     }
        // }

        // //traverse through s
        // StringBuilder t = new StringBuilder();
        // StringBuilder paper = new StringBuilder();
        // for(int i = 0 ; i < n - 1; i++){
        //     if(s.charAt(i) > s.charAt(minCharToRight[i + 1])){
        //         t.append(s.charAt(i));
        //     }else{
        //         //if chota h then process in t
        //         int j = t.length() - 1;
        //         while(j < t.length() && t.charAt(j) < s.charAt(i)){
        //             paper.append(t.charAt(j));
        //             j--;
        //         }
        //     }
        // }

        // return paper.toString();

        int n = s.length();

        // Array to store the smallest character from index i to the end
        char[] minCharToRight = new char[n];
        minCharToRight[n - 1] = s.charAt(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            minCharToRight[i] = (char) Math.min(s.charAt(i), minCharToRight[i + 1]);
        }

        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder paper = new StringBuilder();

        int i = 0;
        while (i < n) {
            stack.push(s.charAt(i));
            char minChar = (i + 1 < n) ? minCharToRight[i + 1] : s.charAt(i);

            while (!stack.isEmpty() && stack.peek() <= minChar) {
                paper.append(stack.pop());
            }

            i++;
        }

        // Empty the remaining characters from the stack
        while (!stack.isEmpty()) {
            paper.append(stack.pop());
        }

        return paper.toString();


    }
}