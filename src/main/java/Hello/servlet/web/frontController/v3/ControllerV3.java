package Hello.servlet.web.frontController.v3;

import Hello.servlet.web.frontController.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap); //Http req, res가 필요하지 않음, 즉 서블릿에 종속적이지 x
}
