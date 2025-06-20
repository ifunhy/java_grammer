package C02ClassBasic;

import java.util.ArrayList;
import java.util.List;

// 변수의 유효범위
public class C05Scope {
    public static int v2 = 10;  // 클래스(전역) 변수

    public static void main(String[] args) {
        // 지역변수의 유효범위
        int v1 = 10;    // 지역 변수
        scope(v1);
        System.out.println(v1);   // 10 (원본은 변하지 않음)

        // 객체의 유효범위
        C04Person p1 = new C04Person();
        p1.setName("kim");
        p1.setEmail("kim@naver.com");
        p1.setAge(20);
        scope2(p1);         // 객체(참조) 전달
        System.out.println(p1.printPerson());   // 30 (메소드에서 변경됨)

        List<C04Person> myList = new ArrayList<>();
        myList.add(p1); // 메모리주소를 add
        myList.get(0).setAge(40);
        System.out.println(p1.printPerson());

        // 클래스변수의 유효범위
        System.out.println("v2: " + v2);

    }

    public static void scope(int v1) {  // call by value
        v1 = 20;    // main의 v1에는 영향 없음 (call by value)
        v2 = 30;    // 클래스 변수 v2는 변경됨
        System.out.println(v1); // 20
    }
    public static void scope2(C04Person p1){    // 힙메모리 주소, call by reference
        p1.setAge(30);  // 객체 내부 상태 변경 -> 원본에도 반영
        System.out.println(p1.printPerson());
    }

}
