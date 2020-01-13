package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DBUtil;


@WebServlet("/destroy")
public class DestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public DestroyServlet() {
        super();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            //セッションスコープからメッセージのIDを取得
            //該当のIDのタスク1件のみをデータベースから取得
            Tasks t = em.find(Tasks.class, (Integer)(request.getSession().getAttribute("task_id")));

            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
            em.close();

            //セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("task_id");

            //indexページへリダイレクト
            response.sendRedirect(request.getContextPath()+"/index");



        }
        }
    }


