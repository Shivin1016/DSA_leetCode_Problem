class Solution {
    public boolean hasAllCodes(String s, int k) {

        int n = s.length();

        // possible substring of length k
        int noOfDistinctSubstring = (int)(Math.pow(2 , k)); 

        Set<String> st = new HashSet<>();

        for(int i = k ; i <= n ; i++){ // goes i to n becuase we have to take last sunstring also
            String str = s.substring(i - k , i);
            st.add(str);
        }

        return st.size() == noOfDistinctSubstring;




    }
}