class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < numRows ; i++){
            ans.add(new ArrayList<>());
        }

        //firstly filled with 1 that is firest row 
        ans.get(0).add(1); //first row filled 
    
        for(int i = 2 ; i <= numRows ; i++){ //start from second row
            int len = i , j = 0;
            while(j < len){
                if(j == 0 || j == len - 1){
                    ans.get(i - 1).add(1);
                }else{
                    List<Integer> prevRow = ans.get(i - 2);
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    ans.get(i - 1).add(sum);
                }
                j++;
            }
        }
        return ans;
    }
}