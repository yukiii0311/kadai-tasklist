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


@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public UpdateServlet() {
        super();

    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

        //セッションスコープからメッセージのIDを取得
        //該当IDのタスク1件をデータベースから取得
        Tasks t = em.find(Tasks.class, (Integer)(request.getSession().getAttribute("task_id")));

        //フォームの内容を各プロパティに上書き
        String title = request.getParameter("title");
        t.setTitle(title);  //タイトル上書き

        String content = request.getParameter("content");
        t.setContent(content);  //コンテンツ上書き

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        t.setUpdated_at(currentTime);  //更新日時のみ上書き

        //データベースを更新
        em.getTransaction().begin();
        em.getTransaction().commit();
        em.close();

        //セッションスコープ上の不要になったデータを削除
        request.getSession().removeAttribute("task_id");

        //indexページへリダイレクト
        response.sendRedirect(request.getContextPath()+"/index");

        }
    }
    }
