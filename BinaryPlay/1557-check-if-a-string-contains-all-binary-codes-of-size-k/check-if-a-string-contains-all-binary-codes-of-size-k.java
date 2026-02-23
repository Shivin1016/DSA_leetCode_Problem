class Solution {
    public boolean hasAllCodes(String s, int k) {

        int n = s.length();

        // possible substring of length k
        int noOfDistinctSubstring = 1 << k;

        Set<String> st = new HashSet<>(); //space complexity => O(2^k * k)

        // O(n * k)
        for(int i = k ; i <= n ; i++){ // goes i to n becuase we have to take last sunstring also
            String str = s.substring(i - k , i);
            if(!st.contains(str)){
                st.add(str);
                noOfDistinctSubstring--;
            }

            if(noOfDistinctSubstring == 0) return true;
        }

        return false;

    }
}