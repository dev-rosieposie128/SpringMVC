package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {

    // 기존에는 void였고 controller가 알아서 forward로 이동했는데,MyView를 만들어서 넘기는 식으로 설계
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
