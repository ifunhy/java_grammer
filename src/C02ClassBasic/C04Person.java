package C02ClassBasic;

public class C04Person {
    // private 접근제어자는 해당 클래스 내에서만 접근 가능
    // 클래서에서 객체변수는 일반적으로 변수의 안정성을 위해 private으로 설정
    private String name;
    private String email;
    private int age;
    private String printPerson;

    // 메소드는 public하게 별도로 만들어서 의도를 명학히 하여, 변수의 안정성 향상
    // setter : 값 설정
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // getter : 값 조회
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    // 객체 상태를 문자열로 출력하는 인스턴스 메소드
    public String printPerson() { //  person은 객체의 주소값이 매개변수로 전달
        return ("이름: " + this.name + ", 이메일: " + this.email + ", 나이: " + this.age);
    }

    // 객체 메소드들끼리의 호출은 '객체가 만들어져있다'라는 것을 가정하고 있으므로, 문제없이 호출 가능
    public String printPerson2() {
        String temp = this.printPerson();
        return  temp;
    }
    
    // 클래스메소드는 기본적으로 객체생성을 가정하지 않으므로, 클래스메소드 내에서 객체메소드를 호출하는 것은 논리적 모순
    public static String printPerson3(){
//        String temp = this.printPerson();   // 불가능
        return null;
    }
}
