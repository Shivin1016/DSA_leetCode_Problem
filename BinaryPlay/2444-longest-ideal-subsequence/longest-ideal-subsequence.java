class Solution { 
    public int longestIdealString(String s, int k) {

        int n = s.length();  
        int maxi = 1; // each letter is itself an subsequence

        //stores length of the longest subseq endng at idx = i
        int[] chars = new int[26];

        for(char ch : s.toCharArray()){

            int idx = ch - 'a';

            //find ranges 
            int longest = 0;
            int left = Math.max(0 , idx - k); // for safe out of bound
            int right = Math.min(idx + k , 25); 

            //now find max-value in range of left to right in chars array
            //then longest ideal subs -> max + 1
            while(left <= right){
                longest = Math.max(chars[left] , longest);
                left++;
            }
            //we add 1 because now new ch is also added in prevous longest subseq
            chars[idx] = longest + 1;
            maxi = Math.max(maxi , chars[idx]);
        }
        return maxi;
    } 
}