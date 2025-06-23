package C04Interface;
import java.util.*;

public class C01InterfaceMain {
    public static void main(String[] args) {
        C01Cat c1 = new C01Cat();
        c1.makeSound();
        C01Dog d1 = new C01Dog();
        d1.makeSound();

        // 다형성 : 하나의 부모타입으로 여러 자식객체를 다룰 수 있음
        // 어떻게 동작하는지 구현체의 실체가 누군지 알아야 함
        C01AnimalInterface1 c2 = new C01Cat();
        c1.makeSound();
        C01AnimalInterface1 d2 = new C01Dog();
        d1.makeSound();

        // 예시
        // 인터페이스의 장점 : 개발의 표준을 지정
        // 다형성(왼쪽에 부모타입 작성)의 장점 : 기존의 구현체를 다른 객체로 변경시 이점
        List<Integer> myList1 = new ArrayList<>();
        myList1.add(10);
        List<Integer> myList2 = new LinkedList<>();
        myList2.add(10);

        // 다중구현(상속)
        C01AnimalInterface1 c3 = new C01Cat();
        c3.makeSound(); //AnimalInterface1에 있는 메소드만 사용 가능
        C01AnimalInterface2 d3 = new C01Dog();
        System.out.println(d3.play("말티푸", "시바견"));  //AnimalInterface2에 있는 메소드만 사용 가능


        // 다중구현 예시 -> 인터페이스에 따라 사용가능 메소드가 제한
        List<Integer> list = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
    }
}




//public class C01InterfaceMain {
//    public static void main(String[] args) {
//        C01Cat c1 = new C01Cat(); // 구체 클래스 인스턴스 생성
//        c1.makeSound(); // Cat 클래스의 makeSound 호출
//        C01Dog d1 = new C01Dog(); // Dog 객체 생성
//        d1.makeSound(); // Dog 클래스의 makeSound 호출
//
//        // 다형성: 인터페이스 타입으로 객체를 다룰 수 있음
//        C01AnimalInterface1 c2 = new C01Cat();
//        c2.makeSound(); // 인터페이스1으로 정의된 메서드만 호출 가능
//        C01AnimalInterface1 d2 = new C01Dog();
//        d2.makeSound(); // 구체 타입은 Dog이지만, 인터페이스 타입으로 참조
//
//        // 다중구현(상속) 예시
//        C01AnimalInterface1 c3 = new C01Cat(); // 인터페이스1 변수에 저장
//        c3.makeSound(); // 인터페이스1 메서드만 접근 가능
//        C01AnimalInterface2 d3 = new C01Dog(); // 인터페이스2 변수에 저장
//        System.out.println(d3.play("말티푸", "시바견")); // 인터페이스2 메서드만 호출 가능
//
//        // 자바 기본 컬렉션도 다중구현 예시
//        List<Integer> list = new LinkedList<>(); // LinkedList는 List, Deque, Queue 등 여러 인터페이스 구현
//        Queue<Integer> queue = new LinkedList<>(); // 인터페이스에 따라 사용 가능한 메서드가 제한됨
//    }
//}