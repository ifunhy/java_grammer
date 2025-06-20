package C02ClassBasic;
import java.util.*;

public class C11RecursiveBasic {
    public static void main(String[] args) {
        recur0(0, 3);
        System.out.println("-----------------------");
        recur1(0, 3);
        System.out.println("-----------------------");
        recur2(new ArrayList<>(), 0, 3);


    }
    
    public static void recur0(int count, int target) {
        if (count == target) {
            return;
        }
        System.out.println("재귀 호출 전 count : " + count); // 0(첫번째) -> 1(두번째) -> 2(세번째)
        recur0(count+1, target);
        System.out.println("재귀 호출 후 count : " + count); // 0(여섯번째) -> 1(다섯번째) -> 2(네번째)
    }

    // 아래 함수 출력 순서 : 전c: 0 -> 전c: 1 -> 전c: 2 -> 후c: 3 -> 후c: 2 -> 후c: 1
    public static void recur1(int count, int target) {
        if (count == target) {
            return;
        }
        System.out.println("재귀 호출 전 count : " + count);
        count = count + 1;
        recur1(count, target);
        System.out.println("재귀 호출 후 count : " + count);
    }

    // 객체를 매개변수로 활용한 재귀함수 : 객체는 힙메모리를 통해 원본객체가 변경될 수 있으므로, 재귀함수 간에 값이 일치되는 현상 발생
    public static void recur2(List<Integer> myList, int num, int target) {
        if (myList.size() == target)
            return;
        myList.add(num);
        recur2(myList, num + 1, target);    // myList객체의 주소에 접근하여 num+1을 하게 되면 이전 재귀상황에서도 값이 담김
        System.out.println(myList);
    }

}
