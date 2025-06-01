class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;

        //sort the array in non - descending order
        Arrays.sort(arr);

        // now minimum abs diff is from the diff of first two elememts of num
        int minAbsDiff = Integer.MAX_VALUE;
        int i = 0 , j = 1;
        while(j < n){
            // if((arr[i] < 0 && arr[j] < 0) || (arr[i] > 0 && arr[j] > 0)){
            int mini = Math.abs(arr[j] - arr[i]) ;
            minAbsDiff = Math.min(minAbsDiff , mini); 
            i++;
            j++;
        }
        System.out.println(minAbsDiff);
        List<List<Integer>> ans = new ArrayList<>();
        for(i = 0 ; i < n - 1; i++){
            if(Math.abs(arr[i + 1] - arr[i]) == minAbsDiff){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                ans.add(temp);
            }
        }
        return ans;

    }
}