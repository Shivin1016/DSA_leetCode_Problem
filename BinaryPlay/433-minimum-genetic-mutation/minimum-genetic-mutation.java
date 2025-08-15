class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {

        //stroe bank in set so that we can access fast
        Set<String> newBank = new HashSet<>();
        for(String st : bank){
            newBank.add(st);
        }

        int level = 0;
        var que = new LinkedList<String>();
        que.offer(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        while(!que.isEmpty()){

            int size = que.size();

            while(size-- > 0){

                String currGene = que.pop();

                //check is this endGene
                if(currGene.equals(endGene)) return level;

                for(char ch : "ACGT".toCharArray()){

                    for(int i = 0 ; i < currGene.length() ; i++){

                        StringBuilder sb = new StringBuilder(currGene);
                        sb.setCharAt(i , ch); //first try with 'A' then, "C" then, 'G' then,'T'

                        String newGene = sb.toString();

                        // check that newGene must not visited and must present in Bank
                        if((!visited.contains(newGene)) && newBank.contains(newGene)){
                            que.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                }
            }
            
            if(!que.isEmpty()){
                level++;
            }
        } 
        return -1;
    }
}