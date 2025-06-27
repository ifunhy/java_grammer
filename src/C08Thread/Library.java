package C08Thread;

import java.nio.file.Paths;

public class Library {
    private static int bookCount = 100;
    // synchronized : 메소드 내에서 1개의 스레드만 실행되도록 강제
    // rdb에 재고관리를 할 경우, synchronized를 통한다 하더라도 쿼리와 commit 실행시점의 차이로 인해 동시성 이슈 발생
//    public synchronized static void borrow() {
    public static void borrow() {
        if(bookCount > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            bookCount -= 1;
            System.out.println("대출 완료");
        } else {
            System.out.println("대출 불가");
        }

    }
    
    // bookCount가 static 변수라 getter에서 this 안 함
    public static int getBookCount() {
        return bookCount;
    }
}
