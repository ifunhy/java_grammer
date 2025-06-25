package C06EtcClass;

public class C03EnumMain {
    public static void main(String[] args) {
        // classGrade를 일반 문자열로 세팅할 경우 -> 정해진 문자열이 아닌, 개별적으로 생성된 문자열 삽입
//        Student s1 = new Student("hong1", "1학년");
//        Student s2 = new Student("hong2", "FIRSTGRADE");
//        Student s3 = new Student("hong3", "FIRST_GRADE");
        // static final을 통해 변수값 관리하는 방법
        // static final을 통해 변수값 관리하는 방법 -> 타입이 String이므로 얼마든지 자유롭게 세팅이 가능한 문제점 존재.
//        Student s1 = new Student("hong1", Grade.c1);
//        Student s2 = new Student("hong2", Grade.c2);
//        Student s3 = new Student("hong3", Grade.c3);

        Student s1 = new Student("hong1", ClassGrade.FIRST_GRADE);
        Student s2 = new Student("hong2", ClassGrade.THIRD_GRADE);
        Student s3 = new Student("hong3", ClassGrade.SECOND_GRADE);
//        Student s4 = new Student("hong3", "SECOND_GRADE"); // 타입 불일치 에러
        System.out.println(s1);
        // eunm 클래스의 내부에는 값이 저장된 순서대로 0부터 index값이 내부적으로 할당
        System.out.println(s1.getClassGrade()); // FIRST_GRADE
        System.out.println(s1.getClassGrade().ordinal()); // 0

    }
}

enum ClassGrade {
    FIRST_GRADE, SECOND_GRADE, THIRD_GRADE
}

//class Grade {
//    static final String c1 = "FIRST_GRADE";
//    static final String c2 = "SECOND_GRADE";
//    static final String c3 = "THIRD_GRADE";
//}

class Student {
    private String name;
    private ClassGrade classGrade;

    public Student(String name, ClassGrade classGrade) {
        this.name = name;
        this.classGrade = classGrade;
    }

    public String getName() {
        return name;
    }

    public ClassGrade getClassGrade() {
        return classGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name +
                ", classGrade=" + classGrade +
                '}';
    }
}