package Hello.servlet.web.frontController.v3.controller;

import Hello.servlet.domain.member.Member;
import Hello.servlet.domain.member.MemberRepository;
import Hello.servlet.web.frontController.ModelView;
import Hello.servlet.web.frontController.v3.ControllerV3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);

/*      
        // 왜 setModel()을 안쓰는지에 대해 -> 불필요한 코드가 생김
        Map<String, Object> model = new HashMap<>();
        model.put("members", members);
        ModelView mv = new ModelView("members");
        mv.setModel(model);*/

        return mv;
    }
}
