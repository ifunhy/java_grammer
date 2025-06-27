package C10Annotation;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.NoSuchElementException;

// 자바 내부적으로 접근하는 걸 확인하는 실습
public class C01Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 리플렉션 : 자바에서 런타임 시점에 클래스의 변수를 수정할 수 있는 기능
        Person p1 = new Person();
        System.out.println(p1);

        // 아래와 같은 방식을 통해 private변수인 name변수에 직접 접근
        Field nameField = Person.class.getDeclaredField("name");  // 선언되어 있는 변수 목록을 뽑아냄
        nameField.setAccessible(true);  // private 이라 할지라도 접근 가능하도록 세팅 변경
        nameField.set(p1, "jiki");
        System.out.println(p1);

    }
}

class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
