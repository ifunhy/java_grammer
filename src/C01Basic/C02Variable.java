//package C01Basic;
//
//import java.math.BigDecimal;
//
//public class C02Variable {
//    public static void main(String[] args) {
//        // 정수 : byte(1바이트), int(4바이트), long(8바이트)
//        byte a = 127;
//        byte b = -128;
//        // 오버플로우 : 자료형이 표현할 수 있는 범위를 넘어선 경우
//        a++;
//        // 언더플로우
//        b--;
//        System.out.println(a);  // -128
//        System.out.println(b);  // 127
//
//        int i1 = 10;
//        long l1 = 10;
//
//        // long은 명시적으로 L을 붙여 long 타입임을 명시하기로 함
//        long l2 = 20L;
//
//        // 실수 : float, double(기본) -> 실수 연산은 오차를 발생시킴
//        float f1 = 1.123f;
//        double d1 = 1.123;
//
//        // 부동소수점 오차 테스트
//        double d2 = 0.1;    // 내부적으로 2진법 변환 후 10진법 출력
//        System.out.println(d2);
//
//        // 누적시 오차 발생을 그대로 출력
//        double total = 0;
//        for (int i = 0; i < 1000; i++) {
//            total += 0.1;
//        }
//        System.out.println(total);
//
//        // 소수점 연산 오차 해결 방법 : 정수로 변환 후 연산하여 추후 나눗셈으로 해결
//        double total2 = 0;
//        for (int i = 0; i < 1000; i++) {
//            total2 += 0.1 * 10;
//        }
//        System.out.println(total2 / 10);
//
//        // 소수점 오차 해결 방법 : BigDecimal 클래스 사용
//        double d3 = 1.03;
//        double d4 = 0.42;
//        System.out.println(d3 - d4);    // 0.6100000000000001
//        BigDecimal b1 = new BigDecimal("1.03");   // 값을 입력받을 때부터 소수점으로 받게 되면 이미 오차가 발생하므로 문자로 입력
//        BigDecimal b2 = new BigDecimal("0.42");
//        double d5 = b1.subtract(b2).doubleValue();
//        System.out.println(d5); // 0.61
//
//        // 문자형 : char
//        char c1 = '가';
//        // 문자열 : String
//        String st1 = "가나";
//        System.out.println(c1);
//
//        // boolean : true or false
//        boolean bl1 = true;
//        System.out.println(bl1);
//        if (bl1) {
//            System.out.println("참입니다.");
//        } else {
//            System.out.println("거짓입니다.");
//        }
//
//        // null도 하나의 타입
//        // 참조형 자료에 값을 할당하지 않으면 null이 할당
//        String str1 = "";
//        String str2 = null;
//        System.out.println(str1.isEmpty());
//        System.out.println(str2.isEmpty()); // null을 대상으로 string의 메소드 사용 불가
//        String[] arr = new String[5];
//        arr[1] = "hello1";
//        arr[3] = "hello3";
//        for (int i = 0; i < 5; i++) {
//            System.out.println(arr[i].length());    // null로 인해 error
//        }
//
//        // 타입 변환
//        // 묵시적 타입 변환, 명시적 타입 변환
//        char ch1 = 'a';
//        int in1 = ch1;
//        System.out.println(in1);
//        // 문자 비교를 위한 묵시적 타입 변환
//        System.out.println('a' > 'b');
//
//        // 알파벳 소문자 제거 문제
//        String str1 = "01abcd123한글123";
//        String answer = "";
//        for (int i = 0; i < str1.length(); i++) {
//            char ch = str1.charAt(i);
//            if (ch < 'a' || ch > 'z') {
//                answer += ch;
//            }
//        }
//        System.out.println(answer);
//
//        // int -> double
//        int in2 = 10;
//        double d6 = in2;
//        System.out.println(d6);
//
//        // double -> int
//        double d7 = 10.5;
//        int in3 = (int)d7;
//        System.out.println(in3);
//
//        // 정수/정수의 경우 소수점 절사 문제 발생
//        // 두 수가 모두 정수이면 결과값이 정수일 것이라고 java가 판단
//        int a3= 1;
//        int b3 = 4;
//        double d = a3 / b3;
//        System.out.println(a3 / b3);  // java에서 정수로 형변환하여 0 출력
//        System.out.println(d);
//        System.out.println((double)a3 / b3);
//
//        // 변수와 상수
//        int a1 = 10;
//        // 변수값 재할당은 가능
//        a1 = 20;
//        // 변수값 재선언하는 것은 불가능
//        int a1 = 30;    // 불가능
//
//        // 상수는 초기값을 할당한 후 재할당하는 것이 불가능
//        // 상수는 final 키워드를 사용
//        final double PI = 3.14;
//        PI = 30;    // 불가능
//    }
//}
