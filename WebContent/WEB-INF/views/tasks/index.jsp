<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>タスク一覧</h2>
        <ul>
            <!--▼タスク一覧表示（タスクの数だけ繰り返す） -->
            <c:forEach var="task" items="${tasks}">
                <li>
                <!--▼id番号を押すと詳細に飛ぶようにリンク設定 -->
                <a href="${pageContext.request.contextPath}/show?id=${task.id}">
                    <!--▼id番号、タイトル、コンテンツを引用 -->
                    <c:out value="${task.id}" />
                </a>
                    <c:out value="${task.title}"></c:out>&gt;
                    <c:out value="${task.content}"/>
                </li>
        </ul>
        </c:forEach>
        </ul>

        <!--▼新規ページへ飛ぶ -->
        <p><a href="${pageContext.request.contextPath}/new">新規タスクの投稿</a></p>

    </c:param>
</c:import>

<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>


