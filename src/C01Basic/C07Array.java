package C01Basic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C07Array {
    public static void main(String[] args) {
//        // 배열 표현식1. 배열 선언 후 할당 방식
//        // 배열은 반드시 사전에 길이가 결정되어야 함
//        int[] arr1 = new int[5];
//        arr1[0] = 10;
//        arr1[1] = 20;
////        arr1[2] = 30;
//        arr1[3] = 40;
//        arr1[4] = 50;
//        arr1[5] = 10;   // index out of bounds 예외 발생. 배열의 길이가 동적으로 늘어날 수 없음
//        System.out.println(arr1[2]);    // int 배열의 경우 0으로 초기화
//
//        // 배열 표현식2. 리터럴 방식
//        int[] arr2 = {10,20,30,40,50};
//
//        // 배열 표현식3.
//        int[] arr3 = new int[]{10,20,30,40,50};
//
//        // 배열 표현식3. 예시
//        ArrayList<int[]> list = new ArrayList<>();
//        list.add(new int[5]);
//        list.add(new int[]{1,3,5,7});
//        System.out.println(list.get(1)[3]); // 7

//        // 배열 표현식4 : 불가 0> 배열의 길이를 반드시 확정시켜야 함
////        int[] arr4 = new int[];
//
//        // Arrays.fill : 배열의 모든 값을 변경
//        String[] arr = new String[5];
//        for (int i = 0; i <arr.length; i++) {
//            arr[i] = "";
//        }
//        Arrays.fill(arr,"");

//        // 85, 65, 90으로 구성된 int배열을 선언하고, 총합과 평균을 구해보시오.
//        int[] arr = new int[]{85, 65, 90};
//        int total = 0;
//        for(int i =0; i <arr.length; i++) {
//            total +=  arr[i];
//        }
//        System.out.println("총합: " + total);
//        System.out.println("평균: " + total/arr.length);

//        // 배열의 최대값, 최소값
//        int[] arr2 = {10, 20, 30, 12, 8, 17};
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 1; i < arr2.length; i++) {
//            if (arr2[i] < min) {
//                min = arr2[i];
//            }
//            if (arr2[i] > max) {
//                max = arr2[i];
//            }
//        }
//        System.out.println("최소값: " + min);
//        System.out.println("최대값: " + max);
//        System.out.println(Arrays.stream(arr2).max());

//        // 배열의 자리 바꾸기
//        int[] arr = {20,10,30};
//        int temp = arr[0];
//        arr[0] = arr[1];
//        arr[1] = temp;
//        System.out.println(Arrays.toString(arr));

//        // 배열 뒤집기
//        int[] arr = {10,20,30,40,50};
//        int[] newArr = new int[arr.length];
//        int index = 0;
//
//        for (int i = arr.length - 1; i >= 0; i--) {
//                newArr[index] = arr[i];
//                index++;
//        }
//        System.out.println(Arrays.toString(newArr));

//        // 배열의 정렬
//        int[] arr = {17,12,20,10,15};
//        Arrays.sort(arr);   // 오름차순 정렬
////        Arrays.sort(arr, Comparator.reverseOrder());    // 원시자료형은 Compartator 사용 불가능. 클래스를 통한 객체만 가능
//        System.out.println(Arrays.toString(arr));
//        String[] stArr = {"abc", "aaa", "acb", "abb"};
//        Arrays.sort(stArr, Comparator.reverseOrder());
//        System.out.println(Arrays.toString(stArr));
        
        // 선택정렬 알고리즘 직접 구현
        int[] arr = {17,12,20,10,15};
        for (int i = 0; i < arr.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = 0;
            temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
        System.out.println(Arrays.toString(arr));   // [10,12,15,17,20]
    }
}
