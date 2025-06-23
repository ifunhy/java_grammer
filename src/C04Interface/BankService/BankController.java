package C04Interface.BankService;

import java.util.Scanner;

public class BankController {
    static BankServiceOriginal bs = new BankServiceOriginal();
    public static void main(String[] args) {
        System.out.println("계좌번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String accountNumber = sc.nextLine();
        BankAccount bankAccount = new BankAccount(accountNumber);
        BankService bankService;
        BankService bs;
        while (true) {
            System.out.println("입금하시려면 1번, 출금하시려면 2번");
            String serviceNumber = sc.nextLine();
            if ("1".equals(serviceNumber)) {
                System.out.println("입금 방식을 선택해주세요. 1.카카오페이 2.토스페이");
                String bankNumber = sc.nextLine();
                bankService = "1".equals(bankNumber) ? new BankKakaoService() : new BankTossService();

                System.out.println("입금하실 금액을 입력해주세요.");
                long money = Long.parseLong(sc.nextLine());
                bankService.deposit(money, bankAccount);
                System.out.println("입금이 완료되었습니다.");
            } else {
                System.out.println("출금 방식을 선택해주세요. 1.카카오페이 2.토스페이");
                String bankNumber = sc.nextLine();
                bankService = "1".equals(bankNumber) ? new BankKakaoService() : new BankTossService();

                System.out.println("출금하실 금액을 입력해주세요.");
                long money = Long.parseLong(sc.nextLine());
                if(bankService.withdraw(money, bankAccount)) {
                    System.out.println("출금이 정상처리 되었습니다.");
                } else {
                    System.out.println("잔액부족으로 출금이 불가능 합니다.");
                }

            }
        }
    }
}
