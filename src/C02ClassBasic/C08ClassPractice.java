package C02ClassBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C08ClassPractice {
    public static void main(String[] args) {
        // 객체 선언 및 List에 2개 정도 add
        List<Account> myList = new ArrayList<>();
        Account a1 = new Account("홍길동", "31212345678", 3431095832000L);
        Account a2 = new Account("김아무개", "12344656789", 100000L);

        myList.add(a1);
        myList.add(a2);
        System.out.println(myList);

//        myList.add(new Account("홍길동", "31212345678", 3431095832000L));
//        myList.add(new Account("김아무개", "12344656789", 100000L));
//
//        // 리스트에 담긴 Account 객체 출력
//        for (Account acc : myList)
//            System.out.println(acc);
    }
}

// Account 클래스 생성(계좌). 계좌주명(name - String), 계좌번호(accountNumber - String), 잔고(balance - long)

class Account {
    private String name;
    private String accountNumber;
    private long balance;

    public Account(String name, String accountNumber, long balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public String toString() {
        return ("계좌주명 : " + name + ", 계좌번호 : " + accountNumber + ", 잔고 : " + balance);
    }
}