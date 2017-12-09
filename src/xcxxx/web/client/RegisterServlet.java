package xcxxx.web.client;

import xcxxx.entity.User;
import xcxxx.service.Impl.BusinessServiceImpl;
import xcxxx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/client/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new User();
            user.setPassword(password);
            user.setUsername(username);
            user.setUserId(WebUtils.makeID());

            BusinessServiceImpl service = new BusinessServiceImpl();
            service.registerUser(user);

            request.setAttribute("message", "注册成功");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            request.setAttribute("message", "注册失败");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
