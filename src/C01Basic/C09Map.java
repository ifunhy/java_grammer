package C01Basic;

import java.util.HashMap;
import java.util.Map;

public class C09Map {
    public static void main(String[] args) {
        // key, value로 이루어진 자료구조
        // key값은 중복이 있으면 value를 덮어쓰기
        Map<String, Integer> sports = new HashMap<>();
        sports.put("농구", 2);
        sports.put("배구", 1);

        // map은 key를 통해 value를 get
        // map에서 key값을 통한 검색 복잡도는 O(1)
        System.out.println(sports.get("농구"));
    }
}
