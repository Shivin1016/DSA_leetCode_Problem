class Solution {
    public int findKthNumber(int n, int k) {

        // time complexity -> O(logn) ^2 
        //space complexxity -> O(logn) // there is base 10 becuse we go diper by multiplying 10 

        //SKip those prefix number who have less then k numbers 
        int curr = 1;
        k -= 1; // as we started from first number 1 then we want k -1 more number
        while(k > 0){ 
            int countNum = count(curr , curr + 1 , n);
            if(countNum <= k){
                //we have to skip this prefix number because it have total numbers less then k 
                // means we will find kth number in another prefix
                curr++;
                k -= countNum;
            }else{
                // we got our kth number in this curr prefix hance we have to go dipper 
                curr *= 10; 
                k -= 1; // we take only one prefix
            } 
        }
        return curr;
    }

    public int count(long curr , long next , int limit){
        int countNum = 0;
        while(curr <= limit){
            countNum += (next - curr);
            //go dipper
            curr *= 10; 
            next *= 10;
            //if the next is greater then limit then take only n + 1 next 
            next = Math.min(next , (long)(limit + 1));
        }
        return countNum;
    }
}