import java.time.LocalDate;
class Solution {
    public int countDay(int month , int day){
        int[] numDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        int m = 0;
        //as index is 0 based so take month - 1
        while(m != (month - 1)){
            days += numDays[m];
            m++;
        }
        days += day; // for last month where month apppear add its day
        return days;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        //using java inbuilt package
        //alice incomin ang outgoing dates
        /*
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
        */

        int aliceArrive = countDay(Integer.parseInt(arriveAlice.substring(0 , 2)) , Integer.parseInt(arriveAlice.substring(3 , 5)));
        int aliceLeave = countDay(Integer.parseInt(leaveAlice.substring(0 , 2)) , Integer.parseInt(leaveAlice.substring(3 , 5)));
        int bobArrive = countDay(Integer.parseInt(arriveBob.substring(0 , 2)) , Integer.parseInt(arriveBob.substring(3 , 5)));
        int bobLeave = countDay(Integer.parseInt(leaveBob.substring(0 , 2)) , Integer.parseInt(leaveBob.substring(3 , 5)));
         
        int arrive = Math.max(aliceArrive , bobArrive);
        int left = Math.min(bobLeave , aliceLeave);

        if(arrive > left) return 0;

        return left - arrive + 1;
    }
}