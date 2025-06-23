package C04Interface;

public class C01AnimalMainClass implements C01AnimalInterface3{
    @Override
    public void makeSound() {

    }

    @Override
    public String play(String a, String b) {
        return "";
    }
}


//// C01AnimalInterface3을 구현한 클래스: 인터페이스3이 1,2를 모두 extends함
//public class C01AnimalMainClass implements C01AnimalInterface3 {
//    @Override
//    public void makeSound() { // 인터페이스1의 makeSound 반드시 구현
//        // 구현부 비워두면 기본 동작 없음
//    }
//
//    @Override
//    public String play(String a, String b) { // 인터페이스2의 play 반드시 구현
//        return ""; // 단순 빈 문자열 반환
//    }
//}