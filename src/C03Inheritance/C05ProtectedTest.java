package C03Inheritance;

public class C05ProtectedTest {
    public static void main(String[] args) {
        C04ProtectedClass p1 = new C04ProtectedClass();
        p1.st1 = "hello python";
//        p1.st2 = "hello python";   // private이라 접근 불가능
        p1.st3 = "hello python";
    }
}

