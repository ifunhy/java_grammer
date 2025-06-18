package C02ClassBasic;

import java.util.Scanner;

public class C02MethodPractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = Integer.parseInt(sc.next());
        if (isPrime(input)) {
            System.out.println("입력하신 숫자는 소수입니다.");
        } else {
            System.out.println("입력하신 숫자는 소수가 아닙니다.");
        }

    }

    // 소수판별기 메소드(isPrime) 생성
    public static boolean isPrime(int n) {

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                // 메소드에서  return을 만나면 메소드가 강제 종료
                return (false);
        }
        return (true);
    }
}
