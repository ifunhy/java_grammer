package C03Inheritance;

// 부모클래스를 상속받을 때, 부모클래스에 기본생성자가 없으면 자식클래스에서 상속시 기본적으로 에러 발생
public class C02SuperKeyword extends SuperParents{
    int a = 10;

    C02SuperKeyword() {
        // super() : 부모클래스의 생성자를 호출하는 메소드. (!= super.변수)
        super(20);
        this.a = 10;
    }

    public static void main(String[] args) {
        C02SuperKeyword c2 = new C02SuperKeyword();
        c2.display();

    }
    public void display() {
        System.out.println("자식의 변수 : " + a);    // 10 출력(자식클래스 우선)
        System.out.println("부모의 변수 : " + super.a);  // 20 출력 (super.변수 -> 부모의 변수a 호출)
    }
}

class SuperParents {
    int a = 20;
    public SuperParents(int a) {
        this.a = a;
    }
//    public SuperParents() { // 에러 방지 위해 깡통 기본생성자 생성
//
//    }
}
