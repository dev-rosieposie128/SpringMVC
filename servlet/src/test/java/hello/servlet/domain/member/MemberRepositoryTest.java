package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach // 각 테스트가 끝날 때, 다음 테스트에 영향을 주지 않도록 각 테스트의 저장소를 clearStore()를 호출하여 초기화했다
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given 이런게 주어졌을 때
        Member member = new Member("rosieposie",22);

        //when 이런걸 실행했을 때
        Member savedMember = memberRepository.save(member);

        //then 결과가 이거여야 해
        Member findMember  = memberRepository.findById(savedMember.getId());
        Assertions.assertThat(findMember).isEqualTo(savedMember);   // 찾아온 멤버는 저장된 멤버와 같아야 함
    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2); // 리스트의 사이즈가 2인가?
        Assertions.assertThat(result).contains(member1, member2);   // 리스트에 member1, member2가 포함되어 있는가?

    }
}
