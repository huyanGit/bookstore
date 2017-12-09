package xcxxx.web.client;

import xcxxx.entity.User;
import xcxxx.service.Impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/client/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        BusinessServiceImpl service = new BusinessServiceImpl();
        User user = service.userLogin(username, password);
        if(user == null){
            request.setAttribute("message","用户名和密码不对");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else{
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("/client/head.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
