package schedule;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ScheduleList scli = new ScheduleList();
        String title,time, date;
        String date_start, date_end;
        int priority, choice;

        while (true) {
            try {
                System.out.println("-------------------------------------");
                System.out.println("### 스케쥴 관리 프로그램 ###");
                System.out.println("  1. 스케쥴 생성");
                System.out.println("  2. 스케쥴 조회");
                System.out.println("  3. 스케쥴 검색(타이틀)");
                System.out.println("  4. 스케쥴 검색(기간)");
                System.out.println("  5. 스케쥴 완료(타이틀)");
                System.out.println("  6. 스케쥴 완료(일자 이전)");
                System.out.println("----------------------------");
                System.out.print("선택 : ");
                choice = in.nextInt();
                if (choice == 1) {
                    System.out.println("-------------------------------------");
                    System.out.println("[스케줄 생성]\n");
                    System.out.print("스케쥴 이름 입력 : ");
                    title = in.next();
                    System.out.print("\n스케쥴 날짜 입력 : ");
                    date = in.next();
                    System.out.print("\n스케쥴 시간 입력 : ");
                    time = in.next();
                    System.out.print("\n스케쥴 중요도 입력(1~5) : ");
                    priority = in.nextInt();
                    System.out.print("생성 하시겠습니까?(yes/no):");
                    String choiceArray = in.next();
                    if(choiceArray.equals("yes")){
                        if(priority >= 1 && priority <= 5)
                        {
                            scli.cteateSchedule(title, date, time, priority);
                        }
                        else{
                            System.out.println("중요도는 (1~5)사이만 입력 가능합니다!");
                            continue;
                        }
                    }
                    else{
                        System.out.println("취소합니다");
                        continue;
                    }
                } else if (choice == 2) {
                    System.out.println("-------------------------------------");
                    System.out.println("[스케줄 조회]\n");
                    scli.schedulePrint();
                } else if (choice == 3) {
                    System.out.println("-------------------------------------");
                    System.out.println("[스케줄 검색(타이틀)]\n");
                    System.out.print("검색할 스케쥴 이름 입력 : ");
                    title = in.next();
                    if (scli.scheduleFind(title) == 1) {
                        scli.scheduleFindTitle_print(title);
                    } else {
                        System.out.println("해당 스케쥴이 존재하지 않습니다.");
                    }
                }
                else if (choice == 4){
                    System.out.println("-------------------------------------");
                    System.out.println("[스케줄 검색(기간)]\n");
                    System.out.print("검색할 스케쥴 시작일 : ");
                    date_start = in.next();
                    System.out.print("\n검색할 스케쥴 종료일 : ");
                    date_end = in.next();
                    scli.scheduleFindDate_print(date_start,date_end);
                }
                else if (choice == 5){
                    System.out.println("-------------------------------------");
                    System.out.println("[스케줄 완료(타이틀)]\n");
                    scli.schedulePrint();
                    System.out.print("완료할 스케쥴 이름 입력 : ");
                    title = in.next();
                    System.out.print("완료할 스케쥴 일자 입력 : ");
                    date = in.next();
                    scli.scheduleFindTitleWithDate(title, date);
                }
                else if (choice == 6){
                    System.out.println("-------------------------------------");
                    System.out.println("[스케줄 완료(일자 이전)]\n");
                    System.out.print("완료할 기준 일자 입력 : ");
                    date = in.next();
                    scli.scheduleFindDate_print("0000/00/00",date);
                    System.out.print("변경 하시겠습니까?(yes/no):");
                    String choiceArray = in.next();
                    if(choiceArray.equals("yes")){
                        scli.scheduleFindDate_point_less(date);
                    }
                    else{
                        System.out.println("취소합니다");
                        continue;
                    }
                }
            }catch(Exception e){
                System.out.println("잘못된 값입니다");
                in.nextLine();
                continue;
            }
        }

    }
}
