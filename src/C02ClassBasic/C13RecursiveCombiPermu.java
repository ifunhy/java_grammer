package C02ClassBasic;

import java.util.*;
import java.io.*;

// 조합(combination)과 순열(permutation)
// 주로 백트래킹 알고리즘 상황에서 사용
public class C13RecursiveCombiPermu {
    public static void main(String[] args) {
        // 2중 for문을 활용하여 helloworld1 helloworld2 ... helloworldn 출력
        int total = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // System.out.println("hello world" + total);
                total++;
            }
        }
//        forRecur(0,2);
        
//        // 위 for문의 반복횟수는 동적으로 결정되지 않고, 정적으로 코딩할 수밖에 없는 한계가 존재
//
//        // 재귀함수 예제 : 조합
//        List<Integer> myList = new ArrayList<>();
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);

//        // 숫자 1,2,3,4,를 가지고 있는 2개짜리 숫자 조합을 이중리스트에 담아 출력
//        // [[1,2], [1,3],[1,4],[2,3],[2,4],[3,4]
//        List<List<Integer>> doubleList = new ArrayList<>();
//        for (int i = 0; i < myList.size(); i++) {
//            for (int j = i + 1; j < myList.size(); j++) {
//                // 값 조립
//                List<Integer> temp = new ArrayList<>();
//                temp.add(myList.get(i));
//                temp.add(myList.get(j));
//                doubleList.add(temp);
//            }
//        }
//        System.out.println(doubleList);

        // 재귀함수를 만들기 위한 for문 변형
//        List<Integer> myList = new ArrayList<>();
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);
//
//        List<List<Integer>> doubleList = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();

//        for (int i = 0; i < myList.size(); i++) {
//            temp.add(myList.get(i));
//            for (int j = i + 1; j < myList.size(); j++) {
//                temp.add(myList.get(j));
//                doubleList.add(new ArrayList<>(temp));   // 주소값 이슈로 같이 덮여써짐. new ArrayList<>(temp) 선언 후 add
//                temp.remove(temp.size() - 1);
//            }
//            temp.remove(temp.size() - 1);
//        }
//        System.out.println(doubleList);


//        List<Integer> myList = new ArrayList<>();
//        myList.add(1);
//        myList.add(2);
//        myList.add(3);
//        myList.add(4);
//
//        List<List<Integer>> doubleList = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        int target = 2;
//        int start = 0;
//        combi(myList, new ArrayList<>(), doubleList, target, start);   // temp 자리에 빈 객체 생성
//        System.out.println(doubleList);
//
//        // 1,2,3,4를 n개씩 뽑은 순열 구하기
//        // [[1,2],[1,3],[1,4],[2,1],[2,2],[2,3] ... [4,3]]
//
//    }

    List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);

    List<List<Integer>> doubleList = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    int target = 2;
    int start = 0;
    boolean[] visited = new boolean[myList.size()]; // [false, false, false]
//    combi(myList, new ArrayList<>(), doubleList, target, start);   // temp 자리에 빈 객체 생성
//        System.out.println(doubleList);

    // 1,2,3,4를 n개씩 뽑은 순열 구하기
    // [[1,2],[1,3],[1,4],[2,1],[2,2],[2,3] ... [4,3]]

    permu(myList, new ArrayList<>(), doubleList, visited , 2);
    System.out.println(doubleList);

}
    static void permu(List<Integer> myList, List<Integer> temp, List<List<Integer>> doubleList, boolean[] visited, int target) {
        if (temp.size() == target) {
            doubleList.add(new ArrayList<>(temp));  // 중요중요중요중요!!!!!!!!!!!
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp.add(myList.get(i));
                permu(myList, temp, doubleList, visited, target);
                temp.remove(temp.size() - 1);
                visited[i] = false;
        }
    }



//    static void combi(List<Integer> myList, List<Integer> temp, List<List<Integer>> doubleList, int target, int start) {
//        if (temp.size() == target) {
//            doubleList.add(new ArrayList<>(temp));  // 중요중요중요중요!!!!!!!!!!!
//            return;
//        }
//
//        for (int i = start; i < myList.size(); i++) {
//            temp.add(myList.get(i));
//            combi(myList, temp, doubleList, target, i + 1);
//            temp.remove(temp.size() - 1);
//        }
//    }






//    static int staticCount = 0;
//    static void forRecur(int num, int target) {
//        if (num == target) {
//            System.out.println("hello world");
//            staticCount++;
//            return;
//        }
//
//        for (int i = 0; i < 3; i++) {
//            forRecur(num+1, target);
//        }
    }
}


// 선 암기로 공부하는 것도 괜찮음 -> 후 이해
// 백준 - 15649 N과 M
// 백준 - 6603 로또

// 주말 : 클래스, 객체 다시 만들어보고 이해
// 재귀, 백트래킹(방문, temp 더했다가 뺐다가) => 코드암기 및 문제풀이