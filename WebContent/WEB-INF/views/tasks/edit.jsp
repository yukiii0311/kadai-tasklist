<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>id:${task.id}のタスク編集ページ</h2>
        <!--▼「update」にデータを送るフォーム -->
        <form method="POST" action="${pageContent.request.contextPath}/update">
            <!--▼「＿form.jsp」をインポート（タイトル、内容入力蘭）-->
            <c:import url="_form.jsp" />
        </form>

        <p>
            <!--▼IndexServletに飛ぶ-->
            <a href="${pageContexxt.request.contextPath}/index">一覧に戻る</a>
        </p>

    </c:param>

</c:import>
