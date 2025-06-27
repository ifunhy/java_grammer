package C08Thread;

public class MyThread extends Thread{   // 멀티스레드를 만들기 위한 Thread클래스(부모클래스) 상속
    // Thread클래스(부모클래스)에 내장된 run메소드는 비어있는 메소드
    // run메소드는 스레드가 시작될 때 자동으로 호출되는 메소드
    // 스레드 실행 시 특정 작업을 수행하고 싶다면, run메소드를 overriding하여 코드 작성
    @Override
    public void run() {
        System.out.println("스레드 실행 시작(MyTread)");
    }
}
