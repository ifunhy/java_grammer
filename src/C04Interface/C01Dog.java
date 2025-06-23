package C04Interface;

public class C01Dog implements C01AnimalInterface1, C01AnimalInterface2{
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }

    @Override
    public String play(String a, String b) {
        return a + "와 " + b + "가 산책합니다.";
    }
}



//// C01AnimalInterface1, C01AnimalInterface2를 다중 구현한 클래스
//public class C01Dog implements C01AnimalInterface1, C01AnimalInterface2 {
//    @Override
//    public void makeSound() { // 인터페이스1의 메서드 구현
//        System.out.println("멍멍"); // 개 울음소리 출력
//    }
//
//    @Override
//    public String play(String a, String b) { // 인터페이스2의 메서드 구현
//        return a + "와 " + b + "가 산책합니다."; // 두 동물 이름 조합하여 반환
//    }
//}
