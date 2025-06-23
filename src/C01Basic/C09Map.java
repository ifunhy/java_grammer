//package C01Basic;
//import java.util.*;
//
//public class C09Map {
//    public static void main(String[] args) {
//        // key, value로 이루어진 자료구조
//        // key값은 중복이 있으면 value를 덮어쓰기
//        Map<String, Integer> sports = new HashMap<>();
//        sports.put("농구", 2);
//        sports.put("배구", 1);
//
//        // map은 key를 통해 value를 get
//        // map에서 key값을 통한 검색 복잡도는 O(1)
//        System.out.println(sports.get("농구"));
//
//        // map의 전체 데이터 출력
//        // map의 key값 접근시에 인덱스 사용 불가능(순서가 없음)
//        // keySet() : map의 key 목록을 리턴하는 메소드
//        // values() : map의 value 목록을 리턴
//        int total = 0;
//        for (int v : sports.values())
//            total += v;
//        int total2 = 0;
//        for (String k : sports.keySet())
//            total2 += sports.get(k);
//
//        // remove : key를 통해 map의 요소 삭제
//        sports.remove("농구");
//        System.out.println(sports);
//
//        // map에서는 기존의 key값에 put할 경우 덮어쓰기
//        sports.put("배구", 10);
//        System.out.println(sports);
//
//        Map<String, String> sports = new HashMap<>();
//        sports.put("soccer", "축구");
//        sports.put("baseball", "야구");
//        sports.put("basketball", "농구");
//        // putIfAbsent : key값이 없는 경우에만 put
//        sports.putIfAbsent("soccer", "운동");
//        sports.putIfAbsent("tennis", "테니스");
//        System.out.println(sports);
//
//        // containsKey : 키가 있으면 true, 없으면 false
//        System.out.println(sports.containsKey("tennis"));
//        System.out.println(sports.containsKey("pingpong"));
//
//        // map 출력 방법 2가지 : 1. foreach문  2. iterator
//        // 1. foreach문
//        for (String a : sports.keySet()) {
//            System.out.println(a);  // key - soccer, basketball, baseball, tennis
//            System.out.println(sports.get(a));  // value - 축구, 농구, 야구, 테니스
//        }
//        // 1.과 같은 방법 : 리턴타입으로 Set으로도 가능 -> 키값만 가지게 됨 -> 키값을 a로 꺼냄
//        Set<String> mySet = sports.keySet();
//        for (String a : mySet) {
//            System.out.println(a);
//        }
//        Map<String, String> sports = new HashMap<>();
//        sports.put("soccer", "축구");
//        sports.put("baseball", "야구");
//        sports.put("basketball", "농구");
//        // 2. iterator 활용
//        // Iterator 객체를 리턴하는 것
//        Iterator<String> iterators = sports.keySet().iterator();
//
//        // next메소드는 데이터를 하나씩 소모시키면서 값을 반환 (순서 보장 안됨)
//        System.out.println(iterators.next());
//        // hasNext메소드는 iterator안에 그 다음값의 여부를 boolean으로 리턴
////        System.out.println(iterator.hasNext());
//        while (iterators.hasNext()) {
//            System.out.println(iterators.next());
//        }
//
//        // map은 key의 value 수를 count하는 목적으로 많이 활용
//        String[] arr = {"농구", "축구", "농구", "야구", "축구"};
//        // 농구:2, 축구:2, 야구:1
//        Map<String, Integer> myMap = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
////            if (myMap.containsKey(arr[i])) {
////                myMap.put(arr[i], myMap.get(arr[i]) + 1);
////            } else {
////                myMap.put(arr[i], 1);
////            }
//            // getOrDefault(키값, 초기값) : key값이 없을 경우 초기값 리턴
//            // key가 있으면 기존 값 +1, 없으면 기본값 0 +1
//            myMap.put(arr[i], myMap.getOrDefault(arr[i], 0) + 1);
//        }
//        System.out.println(myMap);  // 야구=1, 농구=2, 축구=2
//
//        String[] removeArr = {"농구", "농구", "농구", "야구", "축구"};
//        // 농구:2, 축구:2, 야구:1 -> 축구:1
////        for (int i = 0; i < removeArr.length; i++) {
////            String key = removeArr[i];
////            int cnt = myMap.getOrDefault(key, 0);   // key값이 없을 경우 초기값 리턴
////            if (cnt <= 1) {
////                myMap.remove(key);          // 남은 개수가 1 이하 → 키 자체 제거
////            } else {
////                myMap.put(key, cnt - 1);    // 남은 개수가 2 이상 → 1 감소시켜 다시 저장
////            }
////        }
//
//         강사님 코드
//        for (String r : removeArr) {
//            if (myMap.containsKey(r)) {
//                if(myMap.get(r) == 1) {
//                    myMap.remove(r);
//                } else {
//                    myMap.put(r, myMap.get(r) - 1);
//                }
//            }
//        }
//        System.out.println(myMap);  // 축구=1
//
//        Map<String,Integer> myMap = new HashMap<>();
//        myMap.put("축구", 3);
//        myMap.put("농구", 2);
//        myMap.put("야구", 1);
//         가장 value가 큰 key값 찾기
//         최대값 찾는 로직
//        // 1) 기본값 세팅
//        String maxKey = null;
//        int maxVal = Integer.MIN_VALUE;
//
//        // 2) EntrySet 순회하면서 최대값인 key를 찾음
//        for (Map.Entry<String,Integer> entry : myMap.entrySet()) {
//            String key = entry.getKey();
//            int value = entry.getValue();
//            if (value > maxVal) {
//                maxVal = value;
//                maxKey = key;
//            }
//        }
//        System.out.println(maxKey);
//
//        // 강사님 코드
//        int max = Integer.MIN_VALUE;
//        String maxKey = "";
//
//        for (String k : myMap.keySet()) {
//            if (myMap.get(k) > max) {
//                max = myMap.get(k);
//                maxKey = k;
//            }
//        }
//        System.out.println(maxKey);
//
//         백준 - 베스트셀러
//
//         프로그래머스 - 완주하지 못한 선수
//        class Solution {
//            public String solution(String[] participant, String[] completion) {
//                String answer = "";
//                Map<String, Integer> players = new HashMap<>();
//                Map<String, Integer> remove = new HashMap<>();
//
//                // 1) 참가자 수 세기
//                for (String p : participant) {
//                    players.put(p, players.getOrDefault(p, 0) + 1);
//                }
//
//                // 2) 완주자 수만큼 빼기
//                for (String r : completion) {
//                    players.put(r, players.get(r) - 1);
//                }
//
//                // 3) 남은(완주하지 못한) 선수 찾기
//                for (Map.Entry<String,Integer> e : players.entrySet()) {
//                    if (e.getValue() > 0) {
//                        answer = e.getKey();
//                        break;
//                    }
//                }
//                return answer;
//            }
//        }
//
//        // 프로그래머스 - 의상
//        String[][] clothes = new String[4][2];
//        clothes[0][0] = "동그란 안경";
//        clothes[0][1] = "검정 선글라스";
//        clothes[1][0] = "파란 티셔츠";
//        clothes[2][0] = "청바지";
//        clothes[3][0] = "긴 코드";
//
//        Map<String,Integer> map = new HashMap<>();
//        int answer = 1;
//
//        // 1. 종류별로 묶기
//        for (int i = 0; i < clothes.length; i++) {
//            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
//        }
//
//        // 2. 경우의 수 곱하기
//        for (String key : map.keySet()) {
//            answer *= (map.get(key) + 1);
//        }
//
//        // 3. 아무것도 안 입는 경우 제거하기
//        answer -= 1;
//        System.out.println(answer);
////        return answer;
//
//        // LinkedHashMap : 데이터의 삽입순서를 보장(유지)
//        Map<String, Integer> linkedMap = new LinkedHashMap<>();
//        linkedMap.put("hello5", 1);
//        linkedMap.put("hello4", 2);
//        linkedMap.put("hello3", 3);
//        linkedMap.put("hello2", 4);
//        linkedMap.put("hello1", 5);
//
//        for (String l : linkedMap.keySet()) {
//            System.out.println(l);
//        }
//
//        // TreeMap : key를 정렬(오름차순)하여 map을 저장
//        Map<String, Integer> treeMap = new TreeMap<>();
//        treeMap.put("hello5", 1);
//        treeMap.put("hello4", 2);
//        treeMap.put("hello3", 3);
//        treeMap.put("hello2", 4);
//        treeMap.put("hello1", 5);
//
//        for (String l : treeMap.keySet()) {
//            System.out.println(l);
//        }
//
//        // 백준 - 파일 정리
//        // 문자열 자르기 : .은 특수문자로 취급되어 "." -> "\\." 로 해야 함
//    }
//}
