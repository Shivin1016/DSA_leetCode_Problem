class Solution {
    public int numberOfWays(String corridor) {
        int n = corridor.length();

        long count = 1;
        long M = 1000_000_007;
        int seats = 0; 
        for(int i = 0 ; i < n ; i++){
            if(corridor.charAt(i) == 'S'){
                seats++;
            }
        }

        if(seats == 0 || seats % 2 != 0) return 0;

        if(seats == 2) return 1 ; // only one way that is whole string

        //store indx of seats
        int[] seatsIdx = new int[seats];
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            if(corridor.charAt(i) == 'S'){
                seatsIdx[j++] = i;
            }
        }

        int prev_end_idx = 1; // take last idx of first section
        int curr_start_idx = 2;
        while(curr_start_idx < seats){
            count = (count * (seatsIdx[curr_start_idx] - seatsIdx[prev_end_idx])) % M;
            prev_end_idx += 2;
            curr_start_idx += 2;
        }

        return (int)count;
    }
}