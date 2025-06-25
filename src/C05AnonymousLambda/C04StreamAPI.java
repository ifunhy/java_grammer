package C05AnonymousLambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C04StreamAPI {
    public static void main(String[] args) {
//        int[] arr = {20,10,4,12};
//
//        // 전통적인 방식의 데이터 접근 방법 : 메모리 주소 접근
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }

        // 함수형 프로그래밍 방식 : 데이터오 ㅏ객체 중심이 아닌, 입력에 따른 출력만 존재
        // streamAPI : java에서 함수형 프로그래밍을 지원하는 라이브러리
        // foreach는 스트림의 각 요소를 하나씩 소모하면서 동작을 수행
//        Arrays.stream(arr).forEach(a->System.out.println(a));

        // 스트림의 생성 : .stream()
//        List<String> myList = new ArrayList<>();
//        myList.add("HTML");
//        myList.add("CSS");
//        myList.add("javascript");
//        Stream<String> stream1 =  myList.stream();
//        String[] myArr = new String[3];
//        myArr[0] = "HTML";
//        myArr[1] = "CSS";
//        myArr[2] = "javascript";
//        Stream<String> stream2 =  Arrays.stream(myArr);

        // 원시자료형을 위한 stream객체가 별도로 존재.
//        int[] intArr = {10,20,30,40,50};
//        IntStream intStream = Arrays.stream(intArr);

        // stream의 중개연산(변환) : filter, map, sorted, distinct
//        int[] intArr = {10,10,30,40,50};
        // 30보다 작은 값들의 총합
        // filter : 특정기준으로 대상을 filtering하여 새로운 스트림 반환하는 중계연산 메서드
        // sum : 스트림의 요소를 하나씩 소모하여 총합을 구하는 메서드
//        int total = Arrays.stream(intArr).filter(a->a<=30).sum();
//        System.out.println(total);

        // map : 기존의 스트림을 조작하여 새로운 스트림을 반환
//        int[] intArr2 = {10,10,30,40,50};
//        int total2 = Arrays.stream(intArr2).map(a->a*10).sum();
//        int[] newIntArr = Arrays.stream(intArr2).map(a->a*10).toArray();
//        System.out.println(Arrays.toString(newIntArr));

        // distinct : 중복 제거
//        int[] intArr3 = {10,10,30,40,50};
//        int total3 = Arrays.stream(intArr3).distinct().sum();
//        System.out.println(total3);

        // sorted : 정렬
//        int[] intArr4 = {10,10,30,40,50};
//        int[] newArr4 = Arrays.stream(intArr4).sorted().toArray();

        // mapToInt : intstream형태로 변환해주는 map
//        String[] stArr = {"HTML", "CSS", "JAVA", "PYTHON"};
        // 모든 문자열 길이의 총합
//        int lnegthTotal = Arrays.stream(stArr).mapToInt(a->a.length()).sum();

//        int[] arr = {1,2,3,4,5,6};
//        // arr에서 홀수만 담은 배열 생성 후 출력
//        int[] newArr1 = Arrays.stream(arr).filter(a->a%2!=0).toArray();
//        System.out.println(Arrays.toString(newArr1));
//        // arr에서 홀수만 걸러서 해당 홀수의 제곱값을 담은 배열을 생성 후 출력
//        int[] newArr2 = Arrays.stream(arr).filter(a->a%2!=0).map(a->a*a).toArray();
//        System.out.println(Arrays.toString(newArr2));
//        // arr에서 홀수만 거르고, 제곱값을 구하고, 해당 숫자값을 오름차순한 순서로 배열을 생성 후 출력
//        int[] newArr3 = Arrays.stream(arr).filter(a->a%2!=0).map(a->a*a).sorted().toArray();
//        System.out.println(Arrays.toString(newArr3));

        // 스트림의 소모 : foreach(출력), sum(합계), max, min, count, reduce(누적연산), findFirst : stream 첫번째 값 리턴
//        int[] intArr = {10,20,30,40};
//        Arrays.stream(intArr).forEach(a->System.out.println(a));
//        int total = Arrays.stream(intArr).sum();
        // optional객체 : 값이 있을수도 있고, 없을수도 있음을 명시한 객체
//        int max = Arrays.stream(intArr).max().getAsInt();
//        int min = Arrays.stream(intArr).min().getAsInt();
//        long count = Arrays.stream(intArr).count();

        // reduce : 누적연산 -> reduce(초기값, 연산식)
//        int accSum = Arrays.stream(intArr).reduce(0,(a,b)->a+b);
//        int accMultiply = Arrays.stream(intArr).reduce(0,(a,b)->a*b);
//        String[] stArr = {"hello", "java", "world"};
//        String stAcc = Arrays.stream(stArr).reduce("",(a,b)->a+b);
//        System.out.println(stAcc);

        // findFirst : 첫번째 요소 반환
//        System.out.println(Arrays.stream(stArr).filter(a->a.length()>=5).findFirst().get());

        // 주의사항 : 제네릭의 타입 소거
        // 자바의 런타임 시점에 <String>과 같은 제네릭의 타입소거 발생
        // 제네릭의 타입소거로 인해, toArray를 통해 바로 새로운 String배열을 만드는 것이 불가
        String[] stArr = {"hello", "java", "world"};
        String[] answer = Arrays.stream(stArr).filter(a->a.length()>=5).toArray(a->new String[a]);
    }
}