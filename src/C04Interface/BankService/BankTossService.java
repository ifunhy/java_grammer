package C04Interface.BankService;

public class BankTossService implements BankService{
    @Override
    public void deposit(long money, BankAccount ba) {
        // 현재 소지금 조회
        long current = ba.getBalance();
        // 그 금액과 money를 합산하여 updateBalance
        ba.updateBalance(current + money);
    }

    @Override
    public boolean withdraw(long money, BankAccount ba) {
        // 현재 소지금 조회 && 출금금액과 비교
        long current = ba.getBalance();
        if (current < money)
            return (false);
            // 그 금액과 money를 차감하여 updateBalance
        else {
            long newBalance = current - money;
            ba.updateBalance(current - money);
            return (true);
        }
    }
}
