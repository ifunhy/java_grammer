package C01Basic;

public class C03Operator {
    public static void main(String[] args) {
        // 산술연산자 : 사칙연산
        int n1 = 8;
        int n2 = 3;
        // * : 곱셉, / : 나눗셈(몫), % : 나머지
        System.out.println("n1 * n2 = " + (n1 * n2));
        System.out.println("n1 / n2 = " + (n1 / n2));
        System.out.println("n1 % n2 = " + (n1 % n2));

        // 대입연산자
        int n3 = 7;
        int n4 = 7;
        int n5 = 7;
        n3 = n3 - 3;
        n4 -= 3;
        n5 = -3;    // 대입
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);

        int n6 = 10;
        int n7 = 10;
        n6 /= 3;
        n7 %= 3;
        System.out.println(n6);
        System.out.println(n7);

//        // 증감연산자
//        int a = 10;
//        a = a + 1;
//        System.out.println(a);  // 11
//        a += 1;
//        System.out.println(a);  // 12
//        a++;    // 후위증감연산자
//        System.out.println(a);  // 13
//        ++a;    // 전위증감연산자
//        System.out.println(a);  // 14
        
        // a++ : 현재 라인의 명령문이 실행된 후 증가
        // ++a : 현재 라인의 명령문이 실행되기 전 증가
        int a = 10;
        System.out.println(a++);    // 10
        System.out.println(++a);    // 11 + 1 = 12

        int b = 5;
        int c = b++;
        int d = ++b;
        System.out.println(c);  // 5
        System.out.println(d);  // 7

        // 논리연산자 : ==, !=, >, >= 등
        char ch1 = 'a';
        char ch2 = 'b';
        System.out.println(ch1 == ch2);
        System.out.println(ch1 != ch2);

        // 비교연산자 : &&, |, !
        int num1 = 10;
        int num2 = 20;
        boolean b1 = num1 > 5 && num1 < 20;
        System.out.println(b1); // true

        // num2가 10과 30 사이에 있는지 여부를 b2에 값 세팅
        boolean b2 = num2 >= 10 && num2 <= 30;
        boolean b3 = !(num2 < 10 || num2 > 30);
        System.out.println(b2); // true
        System.out.println(b3); // true

        // 비트연산자 : 컴퓨터의 2진체계에서의 연산 방식
        // 비트연산의 부호 : &, |, ^, <<, >>


    }
}
