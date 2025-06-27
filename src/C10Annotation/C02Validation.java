package C10Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.*;

public class C02Validation {
    public static void main(String[] args) throws IllegalAccessException {
        List<Member> memberList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("회원가입 서비스입니다.");
            System.out.println("이름을 입력해주세요.");
            String name = sc.nextLine();
            System.out.println("이메일 입력");
            String email = sc.nextLine();
            Member member = new Member(name, email);
            validate(member);   // @NotEmpty가 붙어있는지 확인 후 값이 비어있는지 검증
            memberList.add(member);
            System.out.println(memberList);
        }
    }

    // validate() 메소드는 런타임에 리플렉션으로 @NotEmpty 어노테이션을 찾기 때문에 @Retention(RetentionPolicy.RUNTIME) 세팅 필요
    static void validate(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(NotEmpty.class)) {    // @NotEmpty 어노테이션을 찾는 부분
                f.setAccessible(true);  // 접근할 수 있도록 true
                String value = (String)f.get(object);
                if (value == null || value.isEmpty()) {
                    NotEmpty n1 = f.getAnnotation(NotEmpty.class);
                    throw new IllegalAccessException(n1.message());
                }
            }
        }
    }
}
class Member {
    private String name;
    @NotEmpty   // 이메일이 비어있으면 안된다는 선언적 코딩
    private String email;

    public Member() {   // 기본생성자 1
    }

    public Member(String name, String email) {  // 기본생성자 2
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
    }
}

@Retention(RetentionPolicy.RUNTIME) // 어노테이션은 default는 컴파일 타임에 동작 -> 일반적으로 런타임 동작으로 변경
// 어노테이션은 선언적 표시이고, 어떠한 기능도 수행하지 않음
@interface NotEmpty {
    // 어노테이션의 속성 정의 방식
    String message() default "this field cannot be empty!!";
}
