package C02ClassBasic;
import java.util.*;

public class C03Class {
    public static void main(String[] args) {
//        System.out.println(MyCalculator.sum(10,20));

//        // A부서의 매출
//        // 20원 매출 발생
//        System.out.println(MyCalculator.sumAcc(20));
//        // 30원 매출 발생
//        System.out.println(MyCalculator.sumAcc(30));
//        // 40원 매출 발생
//        System.out.println(MyCalculator.sumAcc(40));
//        // 누적 합: 90원
//
//        // B부서의 매출
//        // 10원 매출
//        System.out.println(MyCalculator.sumAcc(10));    // 100원 -> 10원이 돼야 함
//        System.out.println(MyCalculator.sumAcc(20));    // 120원 -> 30원이 돼야 함

        // 객체를 활용한 매출 계산
        // A부서 매출 : 10원, 20원
        MyCalculatorInstance mi1 = new MyCalculatorInstance();
        // MyCalculatorInstance.sumAcc(); : static이 없으므로 sumAcc는 호출 불가 -> 객체로 만들어서 호출해야 함
        mi1.sumAcc(10);
        System.out.println(mi1.total);
        mi1.sumAcc(20);
        System.out.println(mi1.total);
        // B부서 매출 : 10원, 20원
        MyCalculatorInstance mi2 = new MyCalculatorInstance();
        mi2.sumAcc(10);
        System.out.println(mi2.total);
        mi2.sumAcc(20);
        System.out.println(mi2.total);

        System.out.println(MyCalculatorInstance.total_count);

        // 자료구조에서 객체 사용 예시
        // 배열
        String[] arr1 = {"hello", "java", "python"};    // arr1은 객체
        Arrays.sort(arr1);  // Arrays.sort는 클래스 메소드
        System.out.println(arr1.length);    // .length는 객체(인스턴스) 메소드


        // 리스트
        List<String> myList = new ArrayList<>();
        Collections.sort(myList);   // 클래스 메소드
        myList.sort(Comparator.naturalOrder()); // 객체(인스턴스) 메소드

    }
    static int total = 0;

    class MyCalculator {
        // static 붙어있으면 클래스변수, static 붙어있지 않으면 객체변수
        public static int sum(int a, int b) {
            return a + b;
        }

        public static int sumAcc(int a) {
            total += a;
            return total;
        }
    }
}

class MyCalculatorInstance {
    int total = 0;
    // 클래스 변수는 모든 인스턴스(객체) 간 상태 공유 목적으로 주로 사용
    static int total_count = 0;

    // 클래스를 만들면, 아래와 같은 클래스명의 이름을 가진 메소드(생성자)가 기본으로 만들어짐(무조건)
    // 생성자의 주된 목적은 객체 생성시 실행되면서, 객체 변수를 초기화하기 위한 목적으로 주로 사용
    public MyCalculatorInstance() {
        total_count++;
    }

    // 클래스메소드는 객체의 상태와 상관없는 독립적인 로직 수행시에 사용 가능
    // 객체변수의 값을 지속적으로 할당할 필요가 없기 때문에 static으로 선언해도 가능
    public static int sum(int a, int b) {
        return a + b;
    }

    public void sumAcc(int total) {
        // this : 객체 그 자신을 의미. 인스턴트 메소드에서만 접근 가능
        // 일반적으로, 매개변수와 객체변수를 구분짓기 위해 사용 (ex> 매개변수명 : total / 객체변수명 : total 일 경우)
        this.total += total;
//        return (total);
    }
}
