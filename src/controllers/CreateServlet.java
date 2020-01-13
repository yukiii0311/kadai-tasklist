package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DBUtil;


@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public CreateServlet() {
        super();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String _token = (String)request.getParameter("_token");

        //CSRF対策チェック。_token に値がセットされていなかったりセッションIDと値が異なったりしたらデータの登録ができない
        //trueにならないのは、意図しない不正なページ遷移によって /create へアクセスされた場合
        if(_token != null && _token.equals(request.getSession().getId())) {

            EntityManager em = DBUtil.createEntityManager();
            Tasks t = new Tasks();

            //---↓new.jspで入力されたデータを格納（start）---

            String title = request.getParameter("titele");
            t.setTitle(title);  //タイトル登録

            String content = request.getParameter("content");
            t.setContent(content);  //コンテンツ登録

            //▼現在の日時を持つ日付型のオブジェクトを取得
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setCreated_at(currentTime);  //作成日時登録
            t.setUpdated_at(currentTime);  //更新日時登録

            //---↑new.jspで入力されたデータの格納（end）---


            //▼格納したデータをデータベースへ保存
            em.getTransaction().begin();
            em.persist(t);;
            em.getTransaction().commit();
            em.close();

            //データベースへの保存が完了したらindexページへリダイレクト
            response.sendRedirect(request.getContextPath()+"/index");

        }


    }

}
