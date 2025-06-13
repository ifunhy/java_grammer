package C01Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C07Array {
    public static void main(String[] args) throws IOException {
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

//        // 선택정렬 알고리즘 직접 구현 : 1)min값 찾기 2)자리 change 3) 이중 for문(index 주의)
//        int[] arr = {17,12,20,10,15};
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[minIndex]) {
//                    minIndex = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[minIndex];
//            arr[minIndex] = temp;
//        }
//        System.out.println(Arrays.toString(arr));   // [10,12,15,17,20]

//        // 버블정렬 알고리즘
//        int[] arr = {17,12,20,10,15};
//        int min = 0;
//
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    min = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = min;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));

//        // 조합문제 : 모두 각기 다른 숫자의 배열이 있을 때, 만들어질 수 있는 두 숫자의 조합을 문자열 형태로 출력
//        // ex> (10,20), (10,30), (10,40), (10,50), (20,30), (20,40), (20,50), (30,~)
//        int[] intArr = {10, 20, 30, 40, 50};
//        // 모든 (i, j) 쌍을 돌면서 조합 출력 (단, i < j)
//        for (int i = 0; i < intArr.length; i++) {
//            for (int j = i + 1; j < intArr.length; j++) {
//                System.out.println("(" + intArr[i] + ", " + intArr[j] + ")");
//            }
//        }

//        // 배열의 중복 제거 : set 자료구조(중복x, 순서x)를 활용하여 중복 제거
//        int[] arr = {10,20,30,30,40};
//        Set<Integer> mySet = new HashSet<>();
//        for (int a : arr) {
//            mySet.add(a);
//        }
//        System.out.println(mySet);
//        int[] answer = new int[mySet.size()];
//        int index = 0;
//        for (int a : mySet){
//            answer[index] = a;
//            index++;
//        }
//        Arrays.sort(answer);
//        System.out.println(Arrays.toString(answer));

//        // 프로그래머스 - 두 개 뽑아서 더하기 (조합 + 중복제거)
//        // numbers = [2,1,3,4,1]	 result = [2,3,4,5,6,7]
//        int[] numbers = new int[]{2,1,3,4,1};
//        Arrays.sort(numbers);
//        ArrayList<Integer> list = new ArrayList<>();
//
//        // 모든 두 수 조합의 합 구하기
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                list.add(numbers[i] + numbers[j]);
//            }
//        }
//
//        // 중복 제거
//        Set<Integer> mySet = new HashSet<>(list);
//
//        // Set → List → 정렬
//        List<Integer> resultList = new ArrayList<>(mySet);
//        Collections.sort(resultList);
//
//        // List<Integer> → int[]
//        int[] result = new int[resultList.size()];
//        for (int i = 0; i < resultList.size(); i++) {
//            result[i] = resultList.get(i);
//        }
//        System.out.println(Arrays.toString(result));
//        // return result;

//        // 배열의 검색
//        int[] arr = {5,3,1,8,7};
//        int target = 8;
//        // 8이 몇 번째 index에 있는지 출력
//        for(int i = 0; i < arr.length; i++) {
//            if (target == arr[i]) {
//                System.out.println("target의 index : " + i);
//                break;
//            }
//        }

//        // 이분탐색(이진탐색) - binary search
//        // 사전에 데이터가 오름차순으로 정렬되어 있을 경우, 이분탐색 가능
//        int[] arr = {1,3,6,8,9,11,15};
//        // 값이 있으면 해당 index 리턴
//        // 값이 없으면 마이너스 값 리턴
//        System.out.println(Arrays.binarySearch(arr, 15));   // (배열, 찾고자 하는 메소드)

//        // 백준 - 수 찾기(1920)
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] arrN = new int[N];
//        StringTokenizer stN = new StringTokenizer(br.readLine());
//
//        // 토큰화한 입력값을 배열에 저장
//        for (int i = 0; i < N; i++)
//            arrN[i] = Integer.parseInt(stN.nextToken());
//        // 시간복잡도로 인해 정렬
//        Arrays.sort(arrN);
//
//        int M  = Integer.parseInt(br.readLine());
//        StringTokenizer stM = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        // 이분탐색
//        for (int i = 0; i < M; i++) {
//            int num = Integer.parseInt(stM.nextToken());    // 토큰화하여 저장
//            if (Arrays.binarySearch(arrN, num) >= 0)
//                sb.append("1\n");
//            else
//                sb.append("0\n");
//        }
//        System.out.println(sb);

//        // 배열값 비교
//        int[] arr1 = {10,20,30};
//        int[] arr2 = {10,20,30};
//        System.out.println(arr1 == arr2);   // false
//        System.out.println(Arrays.equals(arr1,arr2));   // true

//        // 2차원 배열의 선언과 값 할당
//        int[][] arr = new int[3][2];
//        arr[0][0] = 1;
//        arr[0][1] = 2;
//        arr[1][0] = 3;
//        arr[1][1] = 4;
//        arr[2][0] = 5;
//        arr[2][1] = 6;
//        // 리터럴 방식
//        int[][] arr2 = {{1,2},{3,4},{5,6}};
//
//        // 가변배열 : 배열의 전체 길이는 반드시 할당
//        int[][] arr3 = {{1,2},{1,2,3},{1,2,3,4}};
//
//        int[][] arr4 = new int[3][];
//        arr4[0] = new int[2];   // 2차원 배열의 값을 넣기위한 값 지정
//        arr4[1] = new int[3];
//        arr4[2] = new int[4];

//        // [3][4] 사이즈의 배열을 선언하고, 1~12까지 숫자값을 각 배열에 순자척으로 할당
//        // {{1,2,3,4}, {5,6,7,8},{9,10,11,12}}
////        int[][] arr = {{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
//        int[][] arr = new int[3][4];
//        int num = 1;
//        for(int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                arr[i][j] = num;
//                num++;
//            }
//        }
//        System.out.println(Arrays.deepToString(arr));

//        // 2차원 배열의 출력
//        System.out.println(arr);    // arr의 주소값(2차원 배열의 주소값)
//        System.out.println(Arrays.toString(arr));   // arr[]의 주소값(각 1차원 배열의 주소값 모음)
//        // [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]] (각 1차원 배열의 값을 출력)
//        System.out.println(Arrays.deepToString(arr));
////        for (int[] a : arr) {
////            for(int b : a) {
////                System.out.println(Arrays.toString(b));
////            }
////        }

//        // 가변배열 값 채우기
//        int[][] arr2 = new int[3][];
//        int num = 1;
//
//        for(int i = 0; i < arr2.length; i++) {
//            arr2[i] = new int[4];
//            for (int j = 0; j < arr2[i].length; j++) {
//                arr2[i][j] = num;
//                num++;
//            }
//        }
//        System.out.println(Arrays.deepToString(arr2));

//        // 프로그래머스 - 행렬의 덧셈
//        int[][] answer = new int[arr1.length][arr1[0].length];
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr1[i].length; j++) {
//                answer[i][j] = arr1[i][j] + arr2[i][j];
//            }
//        }
//        return answer;

//        // 프로그래머스 - K번째 수
//        int[] array = new int[]{1,5,2,6,3,7,4};
//        int[][] commands = new int[][]{{2,5,3},{4,4,1},{1,7,3}};
//        int[] answer = new int[commands.length];  // 각 command에 대한 결과를 저장할 배열 생성
//
//        for (int i = 0; i < commands.length; i++) {  // 모든 명령어(command)를 순회
//            int start = commands[i][0] - 1;  // i번째부터 자르기 위한 시작 인덱스 (1-based → 0-based)
//            int end = commands[i][1];       // j번째까지 자르기 위한 끝 인덱스 (copyOfRange에서 end는 미포함이므로 그대로 사용)
//            int k = commands[i][2] - 1;      // k번째 수를 가져오기 위한 인덱스 (1-based → 0-based)
//
//            int[] temp = Arrays.copyOfRange(array, start, end);  // array의 일부분을 잘라 새로운 배열 생성
//            Arrays.sort(temp);  // 잘라낸 배열을 오름차순 정렬
//
//            answer[i] = temp[k];  // 정렬된 배열에서 k번째 값을 결과 배열에 저장
//        }
//        System.out.println(Arrays.toString(answer));
////        return answer;

        // 배열 복사 :
        // Arrays.copyOf(배열명, length), Arrays.copyOfRange(배열명, start, end)
        int[] arr = {1,4,2,3,6,1,2,5,7};
        int[] arr1 = Arrays.copyOf(arr, 4);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = Arrays.copyOfRange(arr, 0, 4);
        System.out.println(Arrays.toString(arr2));
    }
}
