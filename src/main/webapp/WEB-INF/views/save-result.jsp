<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
<%--
    뷰에서는 request.getAttribute를 통해 데이터를 꺼낼 수 있음 그러나 너무 복잡해짐, 제공 문법 사용
    <li>id =<%=((Member)request.getAttribute("member")).getUsername()%></li>
--%>
    <li>id =${member.id}</li>
    <li>username = ${member.username}</li>
    <li>age = ${member.age}</li>
</ul>
<a href ="/index.html">메인</a>
</body>
</html>