package Hello.servlet.web.frontController.v1;

import Hello.servlet.web.frontController.v1.controller.MemberFormControllerV1;
import Hello.servlet.web.frontController.v1.controller.MemberListControllerV1;
import Hello.servlet.web.frontController.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.ColorType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// v1/* : 하위의 어떤게 들어와도 해당 서블릿이 호출 되어야함
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    // 어떤 url이 들어오면 controllerV1을 호출해라는 식의 명령
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    // constructor 호출 : alt + insert
    public FrontControllerServletV1() {
        // 해당 url이 요청되면 다음의 Controller를 호출
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV1.service");

        String requestURI = request.getRequestURI(); // 요청된 URI만 추출

        // URI를 키로 넣으면 앞서 map에 저장한 value, 즉 controller가 반환됨
        ControllerV1 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controller.process(request, response); // 다형성에 의해 인터페이스로 받을 수 있음 (부모가 ControllerV1)
    }
}
