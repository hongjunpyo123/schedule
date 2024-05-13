package schedule;

public class Schedule {
    private String title, date, time;
    private int priority; //중요도
    private boolean finished; //완료여부

    public Schedule(String title, String date, String time){
        this.priority = 1; //중요도 기본값 1 초기화
        this.title = title;
        this.date = date;
        this.time = time;
    }
    public Schedule(String title, String date, String time, int priority){
        this.priority = priority; //중요도 설정
        this.title = title;
        this.date = date;
        this.time = time;
        this.finished = false;
    }

    public void schedulePrint() {
        System.out.println("[검색결과]\n"+
                "이름:"+(this.title)+"\n"+
                "날짜:"+(this.date)+"\n"+
                "시간:"+(this.time)+"\n"+
                "중요도:"+(this.priority)+"\n"+
                "완료상태:"+(this.finished)+"\n");
    }

    public String getTitle(){
        return this.title;
    }
    public String getDate(){
        return this.date;
    }
    public String getTime(){
        return this.time;
    }
    public int getPriority(){
        return this.priority;
    }

    public boolean getFinished(){
        return finished;
    }

    public void setFinished(boolean finished){
        this.finished = finished;
    }
}
