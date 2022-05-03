package Hello.servlet.web.frontController.v2;

import Hello.servlet.web.frontController.MyView;
import Hello.servlet.web.frontController.v2.controller.MemberFormControllerV2;
import Hello.servlet.web.frontController.v2.controller.MemberListControllerV2;
import Hello.servlet.web.frontController.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    // constructor 호출 : alt + insert
    public FrontControllerServletV2() {
        // 해당 url이 요청되면 다음의 Controller를 호출
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("FrontControllerServletV2.service");

        String requestURI = request.getRequestURI(); // 요청된 URI만 추출

        // URI를 키로 넣으면 앞서 map에 저장한 value, 즉 controller가 반환됨
        ControllerV2 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // new MyView("/WEB-INF/views/*.jsp")
        MyView view = controller.process(request, response);
        view.render(request, response);
    }

}