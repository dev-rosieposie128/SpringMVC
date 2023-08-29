package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "helloServlet", urlPatterns = "/hello") // /hello로 오면 이게 실행됨
public class HelloServlet extends HttpServlet { // 서블릿은 HttpServlet을 상속받음


    // 서블릿이 호출이 되면 서비스 메서드가 호출이 됨
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);

        System.out.println("HelloServlet.service");

        System.out.println("request" + req);
        System.out.println("response" + resp);

        String username = req.getParameter("username");
        System.out.println(username);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write("hello "+username);
    }
}
