package C03Inheritance;

// final키워드가 붙은 class는 상속 불가
//public class C06AbstractMain extends FinalParents {
public class C06AbstractMain {
    public static void main(String[] args) {
        AbstractDog d1 = new AbstractDog();
        d1.makeSound1();
        d1.makeSound2();

        // 추상클래스는 구현체 없는 메소드가 있으므로, 객체 생성 불가능
//        AbstractAnimal a1 = new AbstractAnimal();

        // 실질적인 객체는 dog클래스를 통해 만들어지므로, 여기서는 d2의 makeSound2 사용 가능
        AbstractAnimal d2 = new AbstractDog();
        d1.makeSound1();
        d1.makeSound2();

        // 모든 메소드가 abstract인 클래스를 인터페이스라 한다.
        // 인터페이스는 구현체가 없으므로, 기본적으로 별도의 객체 생성 불가
//        List<Integer> myList = new List<>();
    }
}

// 추상메소드가 하나라도 있으면 반드시 클래스에도 abstract 키워드를 붙이고, 추상클래스가 됨
abstract class AbstractAnimal{
    void makeSound1(){
        System.out.println("동물은 소리를 냅니다.");
    }
    // 메소드를 선언만 하고 구현이 없는 메소드 선언 시, abstract 키워드 사용
    abstract void makeSound2();
}

class AbstractDog extends AbstractAnimal{   // 상속 받은 거 하나, 안 받은 거 하나. 두 개의 Dog 클래스가 있음

    @Override
    void makeSound2() {
        System.out.println("멍멍");
    }
}

final class FinalParents{

}