import java.time.LocalDate;
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        //alice incomin ang outgoing dates
        LocalDate d1 = LocalDate.of(2021 , Integer.parseInt(arriveAlice.substring(0 , 2)) , Integer.parseInt(arriveAlice.substring(3 , 5)));
        LocalDate d2 = LocalDate.of(2021 , Integer.parseInt(leaveAlice.substring(0 , 2)) , Integer.parseInt(leaveAlice.substring(3 , 5)));

        //bobs incomin ang outgoing dates
        LocalDate d3 = LocalDate.of(2021 , Integer.parseInt(arriveBob.substring(0 , 2)) , Integer.parseInt(arriveBob.substring(3 , 5)));
        LocalDate d4 = LocalDate.of(2021 , Integer.parseInt(leaveBob.substring(0 , 2)) , Integer.parseInt(leaveBob.substring(3 , 5)));

        //now find day in year
        long aliceArrive = d1.toEpochDay();
        long aliceLeave = d2.toEpochDay();
        long bobArrive = d3.toEpochDay();
        long bobLeave = d4.toEpochDay();

        //no days together found
        if(aliceArrive > bobLeave || bobArrive > aliceLeave){
            return 0;
        }

        return (int) (Math.min(bobLeave , aliceLeave) - Math.max(aliceArrive , bobArrive)) + 1;
    }
}