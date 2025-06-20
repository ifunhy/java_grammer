package C02ClassBasic;
import java.util.*;
import java.io.*;

// 계좌개설 및 입출금 서비스 : id(auto_increment), name(String), accountNumber(String), balance(long).
// 주의사항1 : main메서드에서 입출력 처리를 하고, deposit(입금), withdraw(출금), transfer(송금) 메서드는 BankAccount클래스에 생성.
// 주의사항2 : 프로그램은 항상 실행될수 있도록 전체코드를 while(true)처리

// 서비스번호를 입력하세요. 1.개설 2.조회 3.입금 4.출금 5.송금

// 1.계좌개설 : "계좌번호와 현재가지고 계신돈을 입력하세요." -> 자동으로 id값 증가되어 세팅 (List or Map)
// 2.계좌조회 : "계좌조회서비스입니다. 계좌번호를 입력해주세요." -> 잔고출력
// 3.입금 : "계좌입금서비스입니다. 계좌번호와 입금금액을 입력해주세요." -> 현재 계좌의 잔액 출력
// 4.출금 : "계좌출금서비스입니다. 계좌번호와 출금금액을 입력해주세요."(잔액검증) -> "남은 금액은 얼마입니다." 또는 "잔액이 부족합니다." 출력.
// 5.송금 : "송금서비스입니다." "본인의 계좌번호를 입력해주세요." "보내고자 하는 상대방의 계좌번호를 입력해주세요." "송금금액을 입력해주세요."(잔액검증)
//          -> "남은 금액은 얼마입니다." 또는 "잔액이 부족합니다." 출력.
// 나는 항상 this

public class C09BankService {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, BankAccount> accountMap = new HashMap<>();
        StringTokenizer st;

        // BankAccount객체를 담아둘 자료구조 선언 (List or Map)



        while (true) {
            System.out.println("원하시는 서비스의 번호를 입력해주세요.\n1. 계좌개설 / 2. 계좌조회 / 3. 입금 / 4. 출금 / 5. 송금");
            String str = br.readLine();
            // 분기처리  switch-case 또는 if-else
            switch (str) {
                case "1" :
                    System.out.println("계좌개설 서비스입니다. 계좌번호와 이름, 현재 가지고 계신 돈을 입력하세요.");
                    st = new StringTokenizer(br.readLine());

                    String accountNumber = st.nextToken();
                    String name = st.nextToken();
                    long balance = Long.parseLong(st.nextToken());

                    BankAccount newAccount = new BankAccount(name, accountNumber, balance);
                    accountMap.put(accountNumber, newAccount);

                    System.out.println("신규 계좌 생성 완료. id = " + newAccount.getId());
                    break;

                case "2" :   // 잔고 출력
                    System.out.println("계좌조회 서비스입니다. 계좌번호를 입력해주세요.");

                    accountNumber = br.readLine();

                    System.out.println("잔고는 " + accountMap.get(accountNumber).getBalance() + "원 입니다.");
                    break;

                case "3" :
                    System.out.println("계좌입금 서비스입니다. 계좌번호와 입금금액을 입력해주세요.");
                    st = new StringTokenizer(br.readLine());

                    accountNumber = st.nextToken();
                    long amounts = Long.parseLong(st.nextToken());

                    BankAccount a = accountMap.get(accountNumber);
                    long money = a.deposit(amounts);

                    System.out.println("입금이 완료되었습니다. 잔고는 " + money + "원입니다.");
                    break;

                case "4" :
                    System.out.println("계좌출금 서비스입니다. 계좌번호와 출금금액을 입력해주세요.");
                    st = new StringTokenizer(br.readLine());

                    accountNumber = st.nextToken();
                    amounts = Long.parseLong(st.nextToken());

                    BankAccount b = accountMap.get(accountNumber);

                    // 잔액 검증
                    if (b.withdraw(amounts)) {
                        System.out.println("출금이 완료되었습니다. 잔고는 " + b.getBalance() + "원입니다.");
                        break;
                    } else {
                        System.out.println("잔고가 부족합니다.");
                        break;
                    }

                case "5" :
                    System.out.println("송금 서비스입니다. 본인의 계좌번호를 입력해주세요.");
                    String MyAccountNumber = br.readLine();
                    BankAccount my = accountMap.get(MyAccountNumber);    // 본인 계좌번호 확인

                    System.out.println("보내고자 하는 상대방의 계좌번호를 입력해주세요.");
                    String OtherAccountNumber = br.readLine();
                    BankAccount other = accountMap.get(OtherAccountNumber); // 상대 계좌번호

                    System.out.println("송금금액을 입력해주세요.");
                    amounts = Long.parseLong(br.readLine());

                    // 잔액 검증
                    if (my.getBalance() - amounts < 0) {
                        System.out.println("잔고가 부족합니다.");
                        break;
                    }
                    else {
                        long bal = my.transfer(other, amounts);
                        System.out.println("송금이 완료되었습니다. 잔고는 " + bal + "원 입니다.");
                        break;
                    }


            }
        }

    }
}

class BankAccount {
    private static long nextId = 1;    // 클래스 로딩 시 1로 초기화 → 생성될 때마다 ++
    private long id;
    private String name;
    private String accountNumber;
    private long balance;

    public BankAccount(String name, String accountNumber, long balance) {
        this.id = nextId++;
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // getter 생성

    public long getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    // setter 생성 -> 의도를 명확히 한 메소드 생성 (setName -> updateName)
    public long deposit(long money) {
        this.balance += money;
        return this.balance;
    }

    public boolean withdraw(long money) {
        if (this.balance < money) {
            return false;
        }
        this.balance -= money;
        return true;
    }

    // 매개변수로 BankAccount 또는 String의 accountNumber 둘 다 가능
    public long transfer(BankAccount targetAccount, long money) {
        this.withdraw(money);   // 내 계좌에서 출금
        targetAccount.deposit(money);   // 상대 계좌에 입금
        return (this.balance);
    }
}