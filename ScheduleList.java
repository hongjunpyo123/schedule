package schedule;

public class ScheduleList {
    private Schedule[] scheduleArray;
    private int size;
    private int count;
    public ScheduleList(){
        this.size = 10;
        this.scheduleArray = new Schedule[size];
        this.count = 0;
    }
    public void scheduleListAssignment(){
        this.size += 10;
        Schedule[] schedules = new Schedule[this.size];
        for(int i = 0; i < count; i++){
            schedules[i] = this.scheduleArray[i];
        }
        this.scheduleArray = schedules;
    }

    public void scheduleAdd(Schedule sc){
        if(size <= count) {
            scheduleListAssignment();
        }
        this.scheduleArray[count++] = sc;
    }

    public void schedulePrint(){
        for(int i = 0; i < this.count; i++){
            System.out.println("["+(i+1)+"]\n"+
                    "이름:"+(scheduleArray[i].getTitle())+"\n"+
                    "날짜:"+(scheduleArray[i].getDate())+"\n"+
                    "시간:"+(scheduleArray[i].getTime())+"\n"+
                    "중요도:"+(scheduleArray[i].getPriority())+"\n"+
                    "완료 상태:"+(scheduleArray[i].getFinished())+"\n");
        }
    }
    public void cteateSchedule(String title, String date, String time, int priority){
        Schedule mysc = new Schedule(title, date, time, priority);
        scheduleAdd(mysc);
    }

    public int scheduleFind(String title){
        for(int j = 0; j < this.count; j++){
            if(scheduleArray[j].getTitle().contains(title)){
                return 1;
            }
        }
        return -1;
    }
    public void scheduleFindTitle_print(String title){
        for(int i = 0; i < this.count; i++){
            if(scheduleArray[i].getTitle().contains(title)){
                scheduleArray[i].schedulePrint();
            }
        }
    }

    public void scheduleFindDate_print(String date_start, String date_end){
        for(int i = 0; i < this.count; i++){
            if(scheduleArray[i].getDate().compareTo(date_start) >= 0 &&
                    scheduleArray[i].getDate().compareTo(date_end) <= 0){
                scheduleArray[i].schedulePrint();
            }
        }
    }

    public void scheduleFindTitleWithDate(String title, String date){
        for(int i = 0; i < count; i++){
            if(scheduleArray[i].getTitle().contains(title) && scheduleArray[i].getDate().compareTo(date) == 0){
                scheduleArray[i].setFinished(true);
                System.out.println("변경완료!");
            }
        }
    }

    public void scheduleFindDate_point_less(String date){
        for(int i = 0; i < count; i++){
            if(scheduleArray[i].getDate().compareTo(date) <= 0){
                scheduleArray[i].setFinished(true);
                System.out.println((i+1)+"번째 스케쥴 변경 완료");
            }
        }
    }

}
