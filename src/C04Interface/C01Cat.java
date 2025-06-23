package C04Interface;

public class C01Cat implements C01AnimalInterface1, C01AnimalInterface2{
    @Override
    public void makeSound() {
        System.out.println("야옹야옹");
    }

    @Override
    public String play(String a, String b) {
        return b + "와 " + a + "가 산책합니다.";
    }
}


//// C01AnimalInterface1, C01AnimalInterface2를 다중 구현한 클래스
//public class C01Cat implements C01AnimalInterface1, C01AnimalInterface2 {
//    @Override
//    public void makeSound() { // 인터페이스1의 메서드 구현
//        System.out.println("야옹야옹"); // 고양이 울음소리 출력
//    }
//
//    @Override
//    public String play(String a, String b) { // 인터페이스2의 메서드 구현
//        return b + "와 " + a + "가 산책합니다."; // 두 동물 이름 조합하여 반환
//    }
//}
