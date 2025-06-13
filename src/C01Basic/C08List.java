package C01Basic;

import java.util.*;

public class C08List {
    public static void main(String[] args) {
        // List 선언방법
        ArrayList<String> myList1 = new ArrayList<String>();
        ArrayList<String> myList2 = new ArrayList<>();

        // List 선언방법2 : 가장 일반적인 방법
        ArrayList<String> myList3 = new ArrayList<>();  // 왼쪽에 인터페이스, 오른쪽에 클래스

        // 초기값 세팅방법1 : 개별 data add
         myList3.add("java");
         myList3.add("python");
         myList3.add("C++");
        System.out.println(myList3);

        // 초기값 세팅방법2 : 배열을 리스트로 변환
        String[] arr = {"java", "python", "C++"};
        List<String> myList4 = new ArrayList<>(Arrays.asList(arr));
        System.out.println(myList4);

        int[] intArr = {10,20,30};
        List<Integer> myIntList = new ArrayList<>();
        for(int i : intArr) {
            myIntList.add(i);   // add시 오토박싱 자동형변환 발생
        }
        System.out.println(myIntList);

        // add 메서드 : 리스트에 값을 하나씩 추가하는 메소드
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(0, 30);  // list의 중간 데이터 삽입/삭제는 성능 비효율적
        System.out.println(myList);

        // get(index) : 특정 index의 요소 반환
        System.out.println(myList.get(0));

        // size() : 리스트의 개수(길이)를 반환
        System.out.println(myList.size());

        // for문을 활용해서 myList의 값을 하나씩 모두 출력
        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        for(int m : myList) {
            System.out.println(m);
        }

        // remove : 요소 삭제
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        // 1) index를 통합 삭제  2) value를 통한 삭제(중복가능성이 있어 일반적이지 않음)
        myList.remove(0);   // 인덱스 해당 위치 삭제
        System.out.println(myList);
        myList.remove(Integer.valueOf(30)); // 값을 확인하여 삭제
        System.out.println(myList);
        // clear : 요소 전체 삭제
        myList.clear();
        System.out.println(myList.isEmpty());   // true

        // indexOf : 특정값을 찾아 index return (가장 먼저 나오는 값)
        List<Integer> myList2 = new ArrayList<>();
        myList2.add(10);
        myList2.add(20);
        myList2.add(30);
        myList2.add(30);
        System.out.println(myList2.indexOf(30));    // 30의 값이 존재하는 인덱스 위치 반환

        // contains : 값이 있는지 없는지 여부를 리턴
        System.out.println(myList2.contains(20));   // true

        // 프로그래머스 - n의 배수 고르기
        int n = 3;
        int[] numlist = {4,5,6,7,8,9,10,11,12};
        List<Integer> list = new ArrayList<>();

        for(int i : numlist) {
            if (i % n == 0)
                list.add(i);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        System.out.println(Arrays.toString(answer));

        // 정렬 : 방법 2가지(Collections 클래스 사용, 객체 사용)
        List<Integer> myList = new ArrayList<>();
        myList.add(5);
        myList.add(4);
        myList.add(3);
        myList.add(2);
        myList.add(1);

        // Collections.sort()
        Collections.sort(myList);   // 오름차순
        Collections.sort(myList, Comparator.reverseOrder());    // 내림차순
        System.out.println(myList);

        // 객체명(ArrayList클래스).sort()
        myList.sort(Comparator.naturalOrder()); // 오름차순
        myList.sort(Comparator.reverseOrder()); // 내림차순
        System.out.println(myList);

        // 이중리스트 : 리스트 안의 리스트
        // [[1,2],[3,4][5,6]]
        List<List<Integer>> myList = new ArrayList();
        List<Integer> myList1 = new ArrayList<>();
        myList.add(myList1);    // 둘 다 가능
        myList.add(new ArrayList<>());  // 둘 다 가능
        myList.get(0).add(1);
        myList.get(0).add(2);   // [[1,2],[]]
        myList.get(1).add(3);
        myList.get(1).add(4);   // [[1,2],[3,4]]
        myList.add(new ArrayList<>());  // 세 번째 리스트 추가
        System.out.println(myList);

        // for문을 이용해서 [[1,2,3], [4,5,6], [7,8,9], [10,11,12]] 이중리스트 생성
        List<List<Integer>> myList = new ArrayList<>();
        List<Integer> myList1 = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < 4; i++) {
            myList.add(new ArrayList<>());
            for (int j = 1; j < 4; j++) {
                myList.get(i).add(num);
                num++;
            }
        }
        System.out.println(myList);

        // 리스트 안에 배열
        // [{1,2}, {1,2,3}, {1,2,3,4}]
        List<int[]> myList = new ArrayList<>();
        myList.add(new int[2]);
        myList.get(0)[0] = 1;
        myList.get(0)[1] = 2;
        myList.add(new int[3]);
        myList.get(1)[0] = 1;
        myList.get(1)[1] = 2;
        myList.get(1)[2] = 3;
        myList.add(new int[]{1,2,3,4});
        myList.get(2)[0] = 1;
        myList.get(2)[1] = 2;
        myList.get(2)[2] = 3;
        myList.get(2)[3] = 4;
        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }
        // 또 다른 방법의 for문
        // 배열주속ㅄ이 출력 [첫번째배열주소, 두번째배열주소, 세번째배열주소]
        for(int i = 0; i <myList.size(); i++) {
            System.out.println(Arrays.toString(myList.get(i)));
        }
    }
}
