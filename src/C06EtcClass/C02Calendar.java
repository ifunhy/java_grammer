package C06EtcClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

public class C02Calendar {
    public static void main(String[] args) {
        // java.util 패키지의 Calendar 클래스
        Calendar myCalendar = Calendar.getInstance();   // static 메소드인데 return은 객체를 만듦
        System.out.println(myCalendar.getTime());
        System.out.println(myCalendar.get(Calendar.YEAR));          // 연도 : 2025 출력 (static 변수)
        System.out.println(myCalendar.get(Calendar.MONTH) + 1);     // 월 : 6 출력 (static 변수)
        System.out.println(myCalendar.get(Calendar.DAY_OF_WEEK));   // 요일 : 4 출력 (static 변수)
        System.out.println(myCalendar.get(Calendar.DAY_OF_MONTH));  // 일 : 25 출력 (static 변수)
        System.out.println(myCalendar.get(Calendar.HOUR_OF_DAY));   // 24시 체계
        System.out.println(myCalendar.get(Calendar.MINUTE));        // 분
        System.out.println(myCalendar.get(Calendar.SECOND));        // 초

        // java.time 패키지의 LocalDateTime, LocalDate, LocalTime 클래스
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);                  // 2025-06-25
        System.out.println(localDate.getYear());        // 2025
        System.out.println(localDate.getMonth());       // JUNE
        System.out.println(localDate.getMonthValue());  // 6
        System.out.println(localDate.getDayOfMonth());  // 25
        System.out.println(localDate.getDayOfWeek());   // WEDNESDAY

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.getHour());        // 12
        System.out.println(localTime.getMinute());      // 8
        System.out.println(localTime.getSecond());      // 46

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getYear());    // 2025
        System.out.println(localDateTime.getHour());    // 12
        // get 메소드와 ChronoField 메개변수로 다양한 형식의 날짜/시간 정보 조회
        System.out.println(localDateTime.get(ChronoField.YEAR));    // 2025
        System.out.println(localDateTime.get(ChronoField.MONTH_OF_YEAR));   // 6
        System.out.println(localDateTime.get(ChronoField.AMPM_OF_DAY));     // 0 : 오전, 1 : 오후
        System.out.println(localDateTime.get(ChronoField.CLOCK_HOUR_OF_DAY));   // 24시 체계

        // .of : 임의로 특정 시간의 정보 객체를 만들어 내고 싶을 때 사용
        LocalDate birthDay = LocalDate.of(1998, 10, 7);
        System.out.println(birthDay);   // 1998-10-07

        LocalDateTime birthDayTime = localDateTime.of(1998, 10, 7, 16, 20, 30);
        System.out.println(birthDayTime);   // 1998-10-07T16:20:30

    }
}

