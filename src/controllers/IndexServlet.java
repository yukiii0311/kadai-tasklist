package controllers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;
import utils.DBUtil;


@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public IndexServlet() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();  //EntityManagerの生成

        List<Tasks> tasks = em.createNamedQuery("getAllTasks", Tasks.class)
                .getResultList();  //クエリの生成


        em.close();//エンティティマネージャー終了

        //リクエストスコープ。ビューにデータを送るための命令（変数"tasks"に、テーブルのタスク一覧（tasks）をセット）
        request.setAttribute("tasks", tasks);

        //レスポンス画面としてindex.jspを呼び出し（forward）
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/index.jsp");
        rd.forward(request, response);
    }



}


