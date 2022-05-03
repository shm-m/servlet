<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Hello.servlet.domain.member.MemberRepository" %>
<%@ page import="Hello.servlet.domain.member.Member" %>

<%--
비즈니스 로직 구현
<% %> -> 해당 코드를 넣으면 자바 코드 작성 가능
<%@ $> -> 임포트 시 다음의 태그안에 삽입
--%>

<%
    // request, response 자동으로 서블릿으로 변환되어서 사용 가능 - jsp 문법 상 지원
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id = <%=member.getId()%></li>
    <li>username = <%=member.getUsername()%></li>
    <li>age = <%=member.getAge()%></li>
</ul>
<a href ="/index.html">메인</a>
</body>
</html>
