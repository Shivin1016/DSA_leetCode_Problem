class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> prev = new ArrayList<>();

        prev.add(1); // rowIndx = 0

        for(int i = 1 ; i <= rowIndex ; i++){
            int len = i + 1 , j = 0;
            List<Integer> curr = new ArrayList<>();
            while(j < len){
                if(j == 0 || j == len - 1){
                    curr.add(1);
                }else{
                    int sum = prev.get(j - 1) + prev.get(j);
                    curr.add(sum);
                }
                j++;
            }
            prev = curr;
        }

        return prev;
    }
}