package Hello.servlet.web.frontController.v2.controller;

import Hello.servlet.domain.member.Member;
import Hello.servlet.domain.member.MemberRepository;
import Hello.servlet.web.frontController.MyView;
import Hello.servlet.web.frontController.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // Model에 데이터를 보관한다.
        request.setAttribute("member", member); // 리퀘스트 객체 내부의 저장소에 저장

        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
