package C07ExceptionFileParsing;

import java.util.Scanner;

public class C01Exception {
    public static void main(String[] args) {
        // 일반적인 예외처리 방식
        System.out.println("나눗셈 프로그램입니다.");

        Scanner sc = new Scanner(System.in);
        // try : 예외처리로, 예외가 발생할 것으로 예상되는 코드를 try로 감쌈
        try {
            System.out.println("분자를 입력해주세요.");
            int head = Integer.parseInt(sc.nextLine());

            System.out.println("분모를 입력해주세요.");
            int tail = Integer.parseInt(sc.nextLine());
            int result = head / tail;   // 여기서 예외 발생시 try 내부의 아래 코드는 실행되지 않음

            System.out.println("두 수를 나눈 결과 값은 " + result);
        // catch를 통해 예상되는 예외클래스를 분기처리
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누면 안됩니다.");
            // 아래와 같은 방식으로 시스템 로그를 기록
            e.printStackTrace();    // 발생한 에러사항을 터미널에서 보여줌
            System.out.println(e.getMessage()); // 에러사항의 메시지만 간략히 출력
        } catch (NumberFormatException e) {
            System.out.println("문자를 입력하면 안됩니다.");
            e.printStackTrace();
            System.out.println(e.getMessage());
        // Exception은 모든 예외의 조상 클래스
        } catch (Exception e) {
            System.out.println("예상치 못한 에러가 발생했습니다.");
            e.printStackTrace();
        } finally {
            // 예외가 발생하든 하지 않든 무조건 실행되는 구문
            System.out.println("무조건 실행되는 문구입니다.");
        }

    }
}
