package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Tasks;


@WebServlet("/new")
public class NewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public NewServlet() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // CSRF対策（セキュリティ対策、サイト外からPOST送信された投稿を拒否
        request.setAttribute("_token", request.getSession().getId());

        // おまじないとしてのインスタンスを生成）（画面表示時のエラー回避、"文字数0のデータ"をフォームに渡すため）
        request.setAttribute("task", new Tasks());

        //new.jspへ（フォワード
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/tasks/new.jsp");
        rd.forward(request, response);
     }
}