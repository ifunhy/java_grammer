package C01Basic;
import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class C05LoopStatement {
    static int num = 30;
    public static void main(String[] args) {
        int a = 0;
        while (a < 10) {
            System.out.println("hello world");
            a = a + 1;
        }
        // while문을 활용하여 2 ~ 10까지 출력
        int n = 2;
        while (n <= 10)
        {
            System.out.println(n);
            n++;
        }

        // 도어락키 예제 -> 무한반복 + 맞히면 종료되는 도어락키 예제 -> 5회 입력 횟수 제한 있는 도어락키 예제("5회 이상 초과됐습니다.")
        System.out.println("비밀번호를 입력하세요.");
        int i = 0;
        while (i < 5) {
            int answer = 1234;
            Scanner sc = new Scanner(System.in);

            if (answer == sc.nextInt()) {
                System.out.println("문이 열렸습니다.");
                // break 키워드를 통해 가장 가까이 있는 반복문을 즉시 종료
                break;
            }
            else
                System.out.println("비밀번호가 틀렸습니다.");
            i++;
            if (i == 5) {
                System.out.println("비밀번호 5회 초과");
                break;
            }
        }

        // 입력한 숫자의 구구단 단수 출력
        while (true) {
            System.out.println("구구단 단수를 입력해주세요.");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int i = 1;
            int result = 1;

            while (i < 10) {
                result = num * i;
                System.out.println(num + " * " + i + " = " + result);
                i++;
            }
        }

        // do while문 : 무조건 1번은 실행되는 while문
        int a = 100;
        do {
            System.out.println(a);
        }
        while (a < 10);

        // for문 : 초기식, 조건식, 증감식이 모두 포함돼 있는 반복문
        // for문은 사용했던 변수명을 for문이 끝난 후 재선언 가능
        for (int a = 0; a <10; a++) {
            System.out.println(a);
        }

        // 1  10 중 홀수만 출력하기
        for (int i = 1; i <= 10; i++) {
            if (!(i % 2 == 0)) {
                System.out.println(i);
            }
        }

        // 1 ~ 20까지 짝수의 총합 출력
        int sum = 0;
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);

        // 두 수의 최대공약수 찾기
        int a = 24;
        int b = 36;
        int min = 0;
        int answer = 0;

        if (a > b) {
            min = b;
        } else {
            min = a;
        }
        // int min = a > b ? b : a;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i ==0) {
                answer = i;
            }
        }
        System.out.println(answer);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }

        // 소수구하기 : 1과 자신을 제외한 숫자로 나누어지지 않는 수
        // 사용자가 입력한 값이 소수인지 아닌지 판별해주는 프로그램
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        boolean check = false;

        for (int i = 2; i < input; i++) {
            if (input % i == 0) {
                check = true;
                break;
            }
        }
        if (!check) {   // check == false
            System.out.println("소수");
        } else {
            System.out.println("소수 아님");
        }

        // continue : 반복문의 조건식으로 이동하는 명령어
        // 홀수만 출력
        for(int i = 0; i < 11; i++) {
            if (i % 2 != 0) {
                // continue는 코드의 직관성과 가독성을 위해 사용
                continue;
            }
            System.out.println(i);
        }

        // 향상된(enhanced) for문 - for each문
        int[] arr = new int[4];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 5;
        arr[3] = 7;

        // 향상된(enhanced) for문 - for each문
        int[] arr = {1,3,5,7};
        // 일반 for문을 활용한 배열 접근 방식
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        // 향상된 for문을 활용한 배열 접근 방식
        for(int a : arr) {
            System.out.println(a);
        }
        // 일반 for문을 통한 arr의 저장된 값 변경
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 10;
        }
        // 참조형변수(객체타입)는 기본적으로 변수를 통한 출력시 메모리값이 출력
        System.out.println(Arrays.toString(arr));

        // 향상된 for문을 통한 arr의 저장된 값 변경 -> 메모리 접근이 아니기 때문에 원본의 값 변경 불가
        for (int a : arr) {
            a += 10;
        }
        System.out.println(Arrays.toString(arr));

        // 자바 변수의 유효범위 : {}
        int num = 10;
        if (true) {
            num = 20;
            int num2 = 20;
        }
//        num2 = 30;  // if문 중괄호 내에서 정의된 변수는 해당 중괄호 밖에서는 사용 불가.
        System.out.println(num);

        // 다중 반복문
        for (int i = 1; i <= 9; i++) {
            System.out.println(i + "단입니다.");
            for (int j = 1; j <= 9; j++) {
                int result = i * j;
                System.out.println(i + " X " + j + " = " + result);
            }
        }

        // 라벨문 : 반복문에 이름을 붙이는 것
        loop1:
        for (int i =0; i < 10; i++) {
            loop2:
            for (int j = 0; j < 10; j++) {
                if(true) {
                    break loop1;    // 원하는 for문을 라벨링을 통해 종료시킬 수 있음
                }
            }
        }

        // 이차원 배열
        int[][] arr = {{1,2,3}, {4,5,11}, {7,8,9}, {10,11,12}};
        System.out.println(arr[2][1]); // 1번째 배열에 2번째 값을 찾는 것

        // 숫자 11이 위치한 배열의 index값(1,2 또는 3,1) 출력
        // 가장 먼저 찾아지는 11의 위치만 출력

        // 라벨링없는 풀이
        boolean check=false;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==11){
                    check = true;
                    System.out.println("위치는 " + i + ", " + j + "입니다.");
                    break ;
                }
            }
            if(check){
                break;
            }
        }

        // 라벨링을 사용한 풀이
        loop1:
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j]==11){
                    System.out.println("위치는 " + i + ", " + j + "입니다.");
                    break loop1;
                }
            }
        }

        // 100 ~ 200까지 수 중에서 가장 작은 소수 출력

        for (int i = 100; i <= 200; i++) {
            boolean check = false;
            for (int j = 2; j*j <= 100; j++) {
                if (i % j == 0) {
                    check = true;   //  소수가 아님
                    break;
                }
            }
            if (check != true) {  // 소수
                System.out.println("가장 작은 소수: " + i);
                break;
            }
        }

        // 루프문으로 구현
        loop:
        for (int i = 100; i < 201; i++) {
            for (int j = 2; j < Math.sqrt(i)+1; j++) {
                if (i % j == 0) {
                    continue loop;
                }
            }
            System.out.println(i);
        }
    }
}
