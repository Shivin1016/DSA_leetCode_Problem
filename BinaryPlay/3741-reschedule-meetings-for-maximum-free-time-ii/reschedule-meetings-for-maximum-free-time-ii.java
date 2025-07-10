class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> freeArray = new ArrayList<>();
        //starting gap
        freeArray.add(startTime[0]);
        for(int i = 1 ; i < n ; i++){
            freeArray.add(startTime[i] - endTime[i - 1]);
        }
        //for last
        freeArray.add(eventTime - endTime[n - 1]);

        //here two cases are available either we move the event to any direction or we shift the event to left / right 

        //so for moving we have to find maximum freeArray so that event can be filled
        //preComputing of maxFreeRight or maxFreeLeft
        int size = freeArray.size();

        int[] maxFreeRight = new int[size];
        for(int i = n - 1 ; i >= 0 ; i--){
            maxFreeRight[i] = Math.max(maxFreeRight[i + 1] , freeArray.get(i + 1));
        }

        int[] maxFreeLeft = new int[size];
        for(int i = 1 ; i < n ; i++){
            maxFreeLeft[i] = Math.max(maxFreeLeft[i - 1] , freeArray.get(i - 1));
        }

        int maxFree = 0;
        for(int i = 1 ; i < size ; i++){

            int duration = endTime[i - 1] - startTime[i - 1]; 

            //free gaps
            int f1 = freeArray.get(i); //adjacent to right of event
            int f2 = freeArray.get(i - 1);//adjacent to left of event

            //case 1 --> complete moving the event
            if(maxFreeRight[i] >= duration || maxFreeLeft[i - 1] >= duration){
                maxFree = Math.max(maxFree , f1 + duration + f2);
            }
            else{
                //case 2--> shift towards left or right
                maxFree = Math.max(maxFree , f1 + f2);
            }
        }

        return maxFree;



        
    }
}