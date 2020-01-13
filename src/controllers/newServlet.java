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


@WebServlet("/new")
public class newServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public newServlet() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();

        //Task（DTO）のインスタンスを生成
        Tasks t = new Tasks();

        //ｔの各プロパティにデータを代入（書き込む系）
        String title = "taro";
        t.setTitle(title);

        String content = "hello";
        t.setContent(content);

        //作成時間・更新時間を代入（勝手に反映系）
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        t.setCreated_at(currentTime);
        t.setUpdated_at(currentTime);

        //データベースに保存
        em.persist(t);
        em.getTransaction().commit();

        //自動採番された絵IDの値を表示
        response.getWriter().append(Integer.valueOf(t.getId()).toString());
        em.close();
    }

}
