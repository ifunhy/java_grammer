package C01Basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C11QueueStackDeque {
    public static void main(String[] args) {

        // Queue 인터페이스를 LinkedList가 구현한 아래와 같은 방식을 가장 많이 사용
        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(10);
        myQue.add(20);
        myQue.add(30);
        // poll : queue에서 데이터를 삭제하면서, 동시에 return하는 메소드
        int temp = myQue.poll();    // 10
        System.out.println(temp);   // 10
        System.out.println(myQue);  // 20, 30
        // peek : queue에서 데이터를 삭제하기 않고, 가장 앞의 데이터를 return
        int temp2 = myQue.peek();   // 20
        System.out.println(temp2);  // 20
        System.out.println(myQue);  // 20, 30
        
        // LinkedList와 ArrayList 성능 차이 비교
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, i);
        }
        
        ArrayList<Integer> arrayList = new ArrayList<>();   // LinkedList보다 성능 떨어짐
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, i);
        }
    }
}
