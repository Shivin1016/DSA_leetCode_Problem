class Solution {
    public int[] findEvenNumbers(int[] digits) {
 
        int[] mp = new int[10];

        List<Integer> list = new ArrayList<>();
 
        for(int digit : digits){
            mp[digit]++;
        }

        //as we have to make the integer of three digits , so the range three digits integer is from 100 to 999 , so we must check that the given integer from this range staisfy the digits that it contains

        for(int i = 100 ; i <= 998 ; i += 2){ // run always 100 to 999
 
            int num = i;
            int[] frq = new int[10];

            while(num > 0){ // run always 3 times
                int rem = num % 10;
                frq[rem]++;
                num /= 10;
            }
            boolean isContain = true;
            for(int j = 0 ; j < mp.length ; j++){
                if(frq[j] > mp[j]){
                    isContain = false;
                    break;
                }
            }
            if(isContain){
                list.add(i);
            }
        }

        int[] ans = new int[list.size()];
 
        for(int i = 0 ; i < list.size() ; i++){
            ans[i] = list.get(i);
        }
        return ans;
 

    }
 
}