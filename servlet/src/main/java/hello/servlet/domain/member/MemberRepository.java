package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MemberRepository {

    //static을 써서 아무리 많아도 딱 한번만 생성됨 -싱글톤이라 안써도 되는데 일단 함
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;  // id 증가용

    //싱글톤으로 만들 것임. 왜? 현재는 스프링을 톰캣 띄울때만 쓰고 있고 안쓰기 떄문에
    private static final MemberRepository instance = new MemberRepository();

    //무조건 아래의 메소드로 조회하도록!!
    public static MemberRepository getInstance(){
        return instance;
    }

    //싱글톤을 만들 때는 private으로 생성자를 막아야함 - 아무나 생성하지 못하도록
    private MemberRepository(){}

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        // store에 있는 모든 value를 꺼내 새로운 array에 담아준다. 그렇게 하는 이유는 arraylist를 조작해도 store에 있는 value 보호 목적
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
