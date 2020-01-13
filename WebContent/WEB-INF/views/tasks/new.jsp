<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <h2>タスク新規作成ページ</h2>

           <!--▼「create」にデータを送るフォーム -->
        <form method="POST" action="${pageContext.request.contextPath}/create">
          <!--▼「＿form.jsp」をインポート（タイトル、内容入力蘭）-->
            <c:import url="_form.jsp" />
        </form>

        <p>
         <!--▼IndexServletに飛ぶ-->
            <a href="${pageContext.request.contextPath}/index">一覧に戻る</a>
        </p>
    </c:param>

</c:import>