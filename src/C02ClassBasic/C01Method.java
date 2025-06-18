package C02ClassBasic;

public class C01Method {
    public static void main(String[] args) {
//        // for문을 통해 1~10까지 total값 가산 후 출력
//        int total1 = 0;
//        for(int i = 1; i <= 10; i++) {
//            total1 += i;
//        }
//        System.out.println(total1);
//
//        // for문을 통해 10~20까지 total값 가산 후 출력
//        int total2 = 0;
//        for(int i = 10; i <= 20; i++) {
//            total2 += i;
//        }
//        System.out.println(total2);

        // 위 코드의 중복이 지속적으로 발생하므로 반복을 피하기 위해 위 코드의 기능을 모듈화하여 별도로 분리 -> 메소드
        // 클래스메소드 기본 호출 방식 : 클래스명.메소드명()
        int total1 = sumAcc(1,10);
        System.out.println(total1);
        int total2 = sumAcc(10,20);
        System.out.println(C01Method.sumAcc(10,20));    // 클래스명.메소드명()
         // 예외 : 같은 클래스 내에서 정의된 클래스메소드의 호출은 클래스명 생략 가능
        System.out.println(sumAcc(20,30));
    }

    // 접근제어자(public), 클래스메소드(static O)/객체메소드(static X), 반환타입(int, String, 배열 등), 매개변수(input값)
    public static int sumAcc(int start, int end){
        int total = 0;
        for(int i = start; i <= end; i++) {
            total += i;
        }
        return total;
    }
}
