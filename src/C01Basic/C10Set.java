package C01Basic;
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
    }
}
