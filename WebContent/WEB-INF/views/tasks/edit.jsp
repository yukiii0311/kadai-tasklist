<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>id:${task.id}のタスク編集ページ</h2>
        <!--▼「update」にデータを送るフォーム -->
        <form method="POST" action="${pageContext.request.contextPath}/update">
            <!--▼「＿form.jsp」をインポート（タイトル、内容入力蘭）-->
            <c:import url="_form.jsp" />
        </form>

         <!--▼IndexServletに飛ぶ-->
        <p><a href="${pageContext.request.contextPath}/index">一覧に戻る</a></p>

         <!--▼これ押したらjavasclipt（確認ウィンドウの表示）を呼ぶ-->　
        <p><a href="#" onclick="confirmDestroy();">このメッセージを削除する</a></p>

        <!--▼DestroyServletに移動-->
        <form method="POST" action="${pageContext.request.contextPath}/destroy">
          <input type ="hidden" name="_token" value="${_token}"/>
        </form>

        <!--▼確認ウィンドウの表示-->
        <script>
        function confirmDestroy(){
            if(confirm("本当に削除してよろしいですか？")){
                document.forms[1].submit();
            }
        }
        </script>

    </c:param>

</c:import>
