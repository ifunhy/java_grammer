package C04Interface;
// 인터페이스를 사용하는 가장 큰 목적 : 규격 지정 가능
public interface C01AnimalInterface2 {
    String play(String a, String b);
}


//// 인터페이스를 사용하는 가장 큰 목적: 클래스 간에 메서드 서명을 통일하여
//// 다형성을 구현할 수 있도록 함
//public interface C01AnimalInterface2 {
//    String play(String a, String b); // 두 동물이 함께 놀 수 있는 행위를 정의 (메서드 서명)
//}