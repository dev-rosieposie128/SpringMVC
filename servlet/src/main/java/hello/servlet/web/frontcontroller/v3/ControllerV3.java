package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //v2랑 비교하면 굉장히 단순하고 프레임워크에 종속적인 것이지, 서블릿에 종속적이지 않음
    ModelView process(Map<String,String> paramMap);

}
