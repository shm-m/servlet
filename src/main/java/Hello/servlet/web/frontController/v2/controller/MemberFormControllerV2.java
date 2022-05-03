package Hello.servlet.web.frontController.v2.controller;

import Hello.servlet.web.frontController.MyView;
import Hello.servlet.web.frontController.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV2 implements ControllerV2 {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp"); // ctrl + shift + alt + T : inline을 통해 객체와 리턴타입을 합침
    }
}
