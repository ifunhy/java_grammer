package C05AnonymousLambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C03ComparatorComparable {
    public static void main(String[] args) {
        // 자바에서는 비교를 위한 인터페이스가 대표적으로 2개가 제공
        // Comparable 인터페이스 : compareTo 메서드가 선언
        // Comparator 인터페이스 : compare 메서드가 선언

        // String 클래스에 compareTo 메서드 내장
        // String 클래스 및 java의 많은 클래스에서 Comparable을 상속하여 compareTo 메서드를 구현
        String a = "hello";
        String b = "world";
//        System.out.println(a.compareTo(b)); // 마이너스

        List<String> myList = new ArrayList<String>();
        myList.add("java");
        myList.add("c");
        myList.add("c++");
        // String의 compareTo 메소드를 사용하여 정렬이 이루어짐.
        Collections.sort(myList);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("kim", 24));
        studentList.add(new Student("Lee", 20));
        studentList.add(new Student("park", 30));
        studentList.add(new Student("choi", 40));
        studentList.add(new Student("kim", 50));

        // 정렬방법 1. Student 객체에서 Comparable을 직접 구현한 방식
        // 단점 : Student 객체를 직접 수정해야 하므로, 유연성이 떨어짐
        // Collections.sort 에서 Comparable을 구현한 객체를 요구
        Collections.sort(studentList);
//        System.out.println(studentList);

        // 정렬방법 2. Comparator을 구현한 익명객체를 사용
        // Comparator 활용도가 높은 이유는 많은 정렬 메소드에서 Comparator 객체를 요구하기 때문
        studentList.sort((o1, o2) -> o1.getName().compareTo(o2.getName())) ;
        System.out.println(studentList);    // 이름 기준으로 학생 정렬

        String[] stArr = {"hello", "java", "C++", "world2"};
        Arrays.sort(stArr);
        Arrays.sort(stArr, Comparator.reverseOrder());
        // 글자 길이를 기준으로 내림차순
        Arrays.sort(stArr, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.toString(stArr));

        // 백준 : 단어 정렬
        // 1.길이로 정렬 2. 길이가 같으면 문자열 정렬
//        String[] baekjoon = new String[4];
//        baekjoon[0] = "no";
//        baekjoon[1] = "more";
//        baekjoon[2] = "more";
//        baekjoon[3] = "wait";
//        Arrays.sort(baekjoon, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if(o1.length() - o2.length() == 0) {
//                    return o1.compareTo(o2);
//                } else {
//                    return o1.length() - o2.length();
//                }
//            }
//        });

        // 백준 : 절댓값 힙
//        import java.util.*;
//````````import java.io.*;
//
//        public class Ex11286 {
//            public static void main(String[] args) throws IOException {
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                Queue<Integer> pq = new PriorityQueue<>(
//                        (o1, o2) -> {
//                            int abs1 = Math.abs(o1);
//                            int abs2 = Math.abs(o2);
//                            if (abs1 != abs2) {
//                                return abs1 - abs2;
//                            } else return o1 - o2;
//                        }
//                );
//
//                int N = Integer.parseInt(br.readLine());
//
//                for (int i = 0; i < N; i++) {
//                    int x = Integer.parseInt(br.readLine());
//
//                    if (x != 0) {
//                        pq.offer(x);
//                    } else {
//                        System.out.println(pq.isEmpty() ? 0 : pq.poll());
//                    }
//                }
//            }
//        }

        // 배열 안의 배열 정렬
        // [4,5], [1,2], [5,0], [3,1]
        List<int[]> myList2 = new ArrayList<>();
        myList2.add(new int[]{4,5});
        myList2.add(new int[]{1,2});
        myList2.add(new int[]{5,0});
        myList2.add(new int[]{3,1});
        // 정렬 : 리스트 안의 배열에 index 1번째 값을 기준으로 오른차순
        myList2.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];   // 오름차순
            }
        });

        for (int[] m : myList2) {
            System.out.println(Arrays.toString(m));
        }

        // 백준 : 선 긋기

    }
}

class Student implements Comparable<Student> {
//class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' +", age=" + age + '}';
    }

    // 정렬은 결국 2개의 값을 비교하는 것으로, A와 B대상 2개만 있으면 충분
    // 두 수(또는 문자)의 경우, 음수/0/양수 세 값 중에 하나만 return. 이를 통해 정렬 수행
    // this가 앞에 있을 땐 오름차순, this가 뒤에 있으면 내림차순으로 내부적인 정렬로직 동작
    @Override
    public int compareTo(Student o) {
//        return o.getName().compareTo(this.getName()); // 이름 기준으로 학생 정렬
        return this.getAge() - o.getAge();      // 나이 기준으로 학생 정렬
    }
}