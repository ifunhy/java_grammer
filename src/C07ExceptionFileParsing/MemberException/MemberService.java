package C07ExceptionFileParsing.MemberException;

import java.util.*;

// 핵심로직을 구현하는 계층(레이어)
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService() {
        this.memberRepository = new MemberRepository(); // memberRepository가 호출될 때, 초기화
    }

    // 회원 가입
    public void register(String name, String email, String password) throws RuntimeException {

        try {
            Optional<Member> found = memberRepository.findByEmail(email);   // 이메일 중복 여부 확인

            // DB에 이메일이 중복일 경우 예외 발생
            if (found.isPresent()) {
                throw new RuntimeException("중복된 이메일입니다: " + email); // 중복이면 예외 발생시킴
            }

            // 비밀번호가 너무 짧은 경우 예외 발생
            if (password.length() < 8) {
                throw new RuntimeException("비밀번호는 최소 8자 이상이어야 합니다.");
            }

            // 객체를 조립 후 repository를 통해 register
            memberRepository.register(new Member(name, email, password));   // 정상 가입
            System.out.println("회원가입 완료: " + email + "\nid: " + Member.getStaticId());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // 중복일 경우 catch 에서 메시지 출력
        }
    }

    // 회원 상세 조회
    public Member findById(Long id) throws RuntimeException{
        // Optional 객체에 값이 없을 경우 예외 발생. 있으면 Member를 꺼내서 return
        try {
            Optional<Member> foundId = memberRepository.findById(id);
            if (foundId.isEmpty()) {
                throw new RuntimeException("존재하지 않는 회원입니다.");
            }
            Member member = foundId.get();
            System.out.println(member);

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
//        return memberRepository.findById(id).orElseThrow(() -> new NoSuchElementException("id가 없는 값입니다."));
    }

    // 회원 목록 조회
    public List<Member> findAll() {
        List<Member> memberList = new ArrayList<>(memberRepository.findAll());
        System.out.println(memberList);
        return null;
//        return memberRepository.findAll();
    }

    // 로그인
    public void login(String email, String password) throws NoSuchElementException, IllformedLocaleException {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (optionalMember.isEmpty()) {
            throw new NoSuchElementException("잘못된 이메일입니다.");
        }
        if (!optionalMember.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }
    }
}
