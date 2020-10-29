import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReturnQuizzes;
@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String action = request.getParameter("action");
        System.out.println(action);

        if(action == "getQuizzes") {
            ReturnQuizzes.getQuizzes();
        }
    }

}