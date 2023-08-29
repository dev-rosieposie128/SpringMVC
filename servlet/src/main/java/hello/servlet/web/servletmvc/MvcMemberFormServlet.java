package hello.servlet.web.servletmvc;

import hello.servlet.basic.HelloServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HelloServlet {

    //컨트롤러 역할이므로 memberform을 보여주고 싶다면, controller로 요청이 들어오게 됨
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp";    //경로 지정
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // controller -> view 이동시에 사용
        dispatcher.forward(request, response);
        /**
         * 1.servlet에서 jsp를 호출 가능
         * 2.다른서블릿이나 JSP로 이동할 수 있는 기능. 서버 내부에서 다시 호출 발생 = redirect가 아님!!
         * ===> 클라이언트에서 서버로 호출을 하고, 서버안에서 내부적으로 servlet-> jsp를 호출하고 jsp에서 응답을 만들어 클라이언트에게 보냄
         */

        //WEB-INF 하위의 자원들은 외부에서 호출을 해도 호출되지 않는다. 항상 controller를 거쳐 내부에서 forward 되어 오길 바람 = WAS rule
        // http://localhost:8080/jsp/members/new-form.jsp와 달리 localhost:8080/WEB-INF/views/new-form.jsp는 호출이 안된다
     
    }
}
