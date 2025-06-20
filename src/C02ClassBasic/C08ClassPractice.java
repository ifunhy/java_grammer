package C02ClassBasic;

import java.util.*;
import java.io.*;

public class C08ClassPractice {
    public static void main(String[] args) {
        // 객체 선언 및 List에 2개 정도 add
        List<Account> myList = new ArrayList<>();
        // 계좌 개설이 이미 된 상황
        Account a1 = new Account("홍길동", "01234", 200000L);
        Account a2 = new Account("김아무개", "54321", 100000L);

        myList.add(a1);
        myList.add(a2);

        // 계좌번호 목록 조회
        for (Account a : myList) {
            System.out.println(a.getAccountNumber());
        }

        // 사용자1이 사용자2에게 송금
        for (Account a : myList) {
            if (a.getAccountNumber().equals("01234")) {
                a.setBalance(a.getBalance() - 50000);
            }
            if (a.getAccountNumber().equals("54321")) {
                a.setBalance(a.getBalance() + 50000);
            }
        }

        // 계좌 상세 조회 : 계좌번호와 잔고 조회
        for (Account a : myList) {
            System.out.println("계좌번호: " + a.getAccountNumber() + " 잔고 : " + a.getBalance());
        }

        // Map을 자료구조로 활용
        Map<String, Account> accountMap = new HashMap<>();
        // 계좌개설
        accountMap.put("12345", new Account("홍길동","12345", 100000));
        accountMap.put("54321", new Account("김아무개","54321", 100000));

        // 송금
        Account a = accountMap.get("12345");
        Account b = accountMap.get("54321");
        a.setBalance(a.getBalance() - 50000);
        b.setBalance(b.getBalance() + 50000);

        // 계좌조회
        for (String ac : accountMap.keySet()) {
            System.out.println(accountMap.get(ac).getAccountNumber());
        }

        // 리스트 출력 -> toString()이 자동으로 호출되어 객체 정보 출력
        // System.out.println(myList);

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

    public void setBalance(long balance) {
        this.balance = balance;
    }

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