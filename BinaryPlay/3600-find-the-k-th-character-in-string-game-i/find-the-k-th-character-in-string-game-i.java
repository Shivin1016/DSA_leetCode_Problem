class Solution {
    public char kthCharacter(int k) {

        //Approach 01 -> Using extra space --> T.C -> O(k) and S.C -> O(n)
        // List<Character> ans = new ArrayList<>();
        // ans.add('a');

        // int n = ans.size();
        // while(n < k){

        //     for(int i = 0 ; i < n ; i++){
        //         char ch = ans.get(i);
        //         ch =  ch == 'z' ? 'a' : ch + 1;
        //         ans.add(ch);
        //     }

        //     n = ans.size();

        // }

        // return ans.get(k - 1);

        //Approach 02 -> without using extra space
        //finding number of shifts , that how many times a shifts --> and shift is nothing but total number of set bits of (k - 1)

        // int shift = 0;
        // int idx = k - 1;

        // while(idx > 0){
        //     if(idx % 2 == 1) shift++;
        //     idx = idx / 2;
        // }

        //using bitCount function
        int shift = Integer.bitCount(k - 1);

        return (char)('a' + shift);


    }
}