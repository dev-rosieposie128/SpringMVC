package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan	//내 하위 패키지 밑으로 모두 찾아 서블릿 자동등록
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServletApplication.class, args);
	}

}
