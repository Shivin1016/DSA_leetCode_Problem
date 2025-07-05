class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;

        int[] frq = new int[501];

        for(int num : arr){
            frq[num]++;
        }

        int lucky = -1;
        for(int i = 1 ; i < 501 ; i++){ 
            if(i == frq[i]){
                lucky = Math.max(lucky , frq[i]);
            }
        }

        return lucky;
    }
}