package C07ExceptionFileParsing.MemberException;
import java.util.*;

// 저장소 역할을 하는 계층
// DB에 CRUD를 수행하는 계층
public class MemberRepository {
    private List<Member> memberList = new ArrayList<>();
    // 회원 가입
    public void register(Member member) {
        memberList.add(member);
    }

    // 회원 상세 조회
    // 이메일로 멤버 찾아서 회원 정보 리턴
    public Optional<Member> findByEmail(String email) {
        for (Member member : memberList) {
            if (member.getEmail().equals(email))
                return Optional.of(member);
        }
        return Optional.empty();
//        return memberList.stream().filter(m -> m.getEmail() == email).findFirst();
    }

    // 아이디로 멤버 찾아서 리턴
    public Optional<Member> findById(Long id) {
        for (Member member : memberList) {
            if (member.getId().equals(id))
                return Optional.of(member);
        }
        return Optional.empty();
//        return memberList.stream().filter(m -> m.getId() == id).findFirst();
    }

    // 회원 목록 조회
    public List<Member> findAll() {
        return new ArrayList<>(memberList);
    }
}
