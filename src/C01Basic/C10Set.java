package C01Basic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C10Set {
    public static void main(String[] args) {
        // Set은 중복 X, 순서보장 X
        Set<String> mySet = new HashSet<>();
        mySet.add("h");
        mySet.add("e");
        mySet.add("l");
        mySet.add("l");
        mySet.add("o");
        mySet.add("e");
        System.out.println(mySet);

        
        // 백준 : 숫자카드
      import java.io.*;
      import java.util.*;

        public class Ex10815 {
            public static void main(String[] args) throws IOException{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                int N = Integer.parseInt(br.readLine());
                String[] strN = br.readLine().split(" ");
                Set<String> cards = new HashSet<>(Arrays.asList(strN));

                int M = Integer.parseInt(br.readLine());
                String[] strM = br.readLine().split(" ");

                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < M; i++) {
                    if (cards.contains(strM[i])) {
                        sb.append("1 ");
                    } else {
                        sb.append("0 ");
                    }
                }
                System.out.println(sb.toString().trim());
            }
        }

        // 프로그래머스 - 폰켓몬
        import java.util.*;

        class Solution {
            public int solution(int[] nums) {
                int N = nums.length;

                Set<Integer> distinctSet = new HashSet<>();

                for (int i = 0; i < N; i++) {
                    distinctSet.add(nums[i]);
                }

                int distinctCount = distinctSet.size();
                int maxPick = N / 2;

                return (Math.min(distinctCount, maxPick));
            }
        }


        // LinkedHashSet:
        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(1);
        linkedSet.add(1);
        linkedSet.add(0);
        linkedSet.add(3);
        linkedSet.add(1);
        System.out.println(linkedSet);  // 1, 0, 3

        // TreeSet: 입력 순서 보장
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(1);
        treeSet.add(0);
        treeSet.add(3);
        treeSet.add(1);
        System.out.println(treeSet);    // 0, 1, 3


        // 집합관련함수 : 교집합(retainAll), 합집합(addAll), 차집합(removeAll)
        Set<String> set1 = new HashSet<>();
        set1.add("java");
        set1.add("python");
        set1.add("c++");
        Set<String> set2 = new HashSet<>();
        set2.add("java");
        set2.add("html");
        set2.add("css");
        set1.retainAll(set2);   // set1에는 java만 남음
        System.out.println(set1);
        set1.addAll(set2);
        System.out.println(set1);   // java,python,c++,html,css
        set1.removeAll(set2);
        System.out.println(set1);   // python, c++
    }
}
