class Solution {
    public boolean reorderedPowerOf2(int n) {

        String target = sortedString(n); // make string of the n 

        for(int i = 0 ; i < 31 ; i++){
            // check one by one for all 2 ki power till the 31 bit representation
            // and make both sort then check if they equal return ture
            if(sortedString(1 << i).equals(target)){  
                return true;
            }
        }

        return false;
    }

    public String sortedString(int x){ 
        char[] arr = String.valueOf(x).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}