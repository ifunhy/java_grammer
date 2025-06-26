package C07ExceptionFileParsing.MemberException;

import java.util.Scanner;

// 사용자의 입출력을 받아 처리하는 계층
public class MemberController {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();  // MemberService 객체 호출
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. 회원가입 / 2. 회원 상세 조회 / 3. 회원 목록 조회 / 4. 로그인(추가사항)");
            String input = sc.nextLine();
            if (input.equals("1")) {
                // 이름, 이메일, 패스워드 입력 받아서 service에 전달해서 회원가입
                System.out.println("회원가입\n이름 : ");
                String name = sc.nextLine();
                System.out.println("이메일 : ");
                String email = sc.nextLine();
                System.out.println("패스워드 : ");
                String password = sc.nextLine();

                // 예외발생 시 적잘한 문구를 사용자에게 출력
                memberService.register(name, email, password);

            } else if (input.equals("2")) {
                // 회원정보 출력
                System.out.println("조회하고자 하는 회원의 id를 입력하세요.");
                Long id = Long.parseLong(sc.nextLine());

                // 적절한 예외처리 필요
                memberService.findById(id);

            } else if (input.equals("3")) {
                // 회원 목록 정보 출력 (List)
                System.out.println("회원 목록");

                memberService.findAll();
            } else if (input.equals("4")) {
                String email = sc.nextLine();
                String password = sc.nextLine();
                try {
                    memberService.login(email, password);
                    System.out.println("로그인 성공입니다.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
}
