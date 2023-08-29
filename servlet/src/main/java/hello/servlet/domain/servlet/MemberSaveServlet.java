package hello.servlet.domain.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));   // request의 getParameter 결과는 항상 문자! 그러므로 타입을 변환해 주어야 한다

        Member member = new Member(username,age);
        memberRepository.save(member);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();

        //자바 코드로 더해야 하기 때문에 굉장히 불편
        w.write("<!DOCTYPE html>\n"+
                "<html>\n"+
                "<head>\n"+
                "<meta charset=\"UTF-8\">\n"+
                "<title>Title</title>\n"+
                "</head>\n"+
                "<body>\n"+
                "성공\n"+
                "<ul>\n"+
                "   <li>id="+member.getId()+"</li>\n"+
                "   <li>username="+member.getUsername()+"</li>\n"+
                "   <li>age="+member.getAge()+"</li>\n"+
                "</ul>\n"+
                "<a href=\"/index.html\">메인</a>\n"+
                "</body>\n"+
                "</html>\n");
    }
}
