package C04Interface.BankService;

public class BankAccount {
    private String accountNumber;
    private long balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // 최종 금액을 통해 update : 아래 메소드를 입/출금 모두에 활용
    public void updateBalance(long balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}

// 계좌 클래스 생성 -> 계좌 개설 및 입/출금
// 클래스의 역할 : 한 클래스에서 모든 작업 x -> Controller(사용자와 인터페이스), Service(핵심로직처리) 계층 도입