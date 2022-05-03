package Hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 서블릿을 활용한 요청 & 응답

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // 서블릿 어노테이션 name : 서블릿 이름 urlPatterns : URL 매핑
public class HelloServlet extends HttpServlet {

    // ctrl + o -> service(protected) 메소드 호출
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); //soutm
        System.out.println("request = " + request); //soutv
        System.out.println("response = " + response);
        // 결과 : request = org.apache.catalina.connector.RequestFacade@1888f743
        //response = org.apache.catalina.connector.ResponseFacade@6ae124b1 - was 서버의 구현체

        String username =  request.getParameter("username"); //URL에 있는 쿼리파라미터를 조회
        System.out.println("username = " + username);

        //응답 메세지에 데이터 담기 - 개발자도구로 확인
        //header에 들어갈 부분들
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        
        //body에 들어갈 부분
        response.getWriter().write("hello " + username);

    }
}
