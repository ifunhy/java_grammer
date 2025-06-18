package C02ClassBasic;


public class C07Constructor {
    public static void main(String[] args) {
        Calendar c1 = new Calendar("2025", "06", "18");
        System.out.println(c1);
    }

}
// 캘린더 객체 생성 : 연도, 월, 일 세팅 (Setter 사용)
// 캘린더 객체 출력 : "오늘은 xxxx년 xx월 xx일 입니다." (Getter 사용)
class Calendar {
    private String  year;
    private String  month;
    private String  day;

    // 위의 별도 생성자를 추가할 경우, 초기(기본)생성자는 무시가 되므로, 필요시 별도로 추가

    // 생성자를 통해 객체변수값들을 객체가 만들어지는 시점에 초기화(세팅)
    public Calendar(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getYear() {
        return year;
    }

//    public void setYear(String year) {
//        this.year = year;
//    }

    public String getMonth() {
        return month;
    }

//    public void setMonth(String month) {
//        this.month = month;
//    }

    public String getDay() {
        return day;
    }

//    public void setDay(String day) {
//        this.day = day;
//    }

    public String toString() {
        return ("오늘은 " + year + "년 " + month + "월 " + day + "일 입니다.");
    }
}

// Calendar 클래스 생성 : year, month, day 모두 String

// setName도 쓰지말자 -> 생성 시점에 할당하자