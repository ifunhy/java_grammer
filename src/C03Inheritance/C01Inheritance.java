package C03Inheritance;

// extends 키워드를 통해 상속을 수행 -> 부모의 변수와 메소드를 자식클래스에서 물려받는 것. private는 예외
// java에서는 클래스의 다중상속을 지원하지 않음 (ex> extends Parent1, Parent2, Parent3). 메소드 중복 가능성 있기 때문. 재정의 시 허용
public class C01Inheritance extends Parents {
    public int b = 20;

    public static void main(String[] args) {
        C01Inheritance c1 = new C01Inheritance();
        // 자식클래스에서 부모클래스의 a변수 상속
        System.out.println(c1.a);
        System.out.println(c1.b);
//        System.out.println(c1.c); 출력불가

        // 메소드 상속
        c1.m1();
        c1.m2();
    }

    // 부모메소드의 재정의(overriding) : 부모클래스의 메소드명과 자식클래스의 메소드명이 동일한 상황
    @Override // override된 메소드임을 명시적으로 표현하는 표현식. 성능 최적화를 이해서 해당 키워드 붙여주는 것이 더 좋음
    public void m1() {
        System.out.println("자식클래스입니다.");
    }

    public void m2() {
        System.out.println("자식클래스의 m2메소드입니다.");
    }
}

class Parents {
    public int a = 10;
    // private 접근제어자는 클래스 내부에서만 접근 가능. 자식클래스에서도 접근 불가
    private int c = 20;

    public void m1() {
        System.out.println("부모클래스입니다.");
        System.out.println(c);
    }
    public void m2() {
        System.out.println("자식클래스의 m2메소드입니다.");
    }
}
