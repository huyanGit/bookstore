package xcxxx.web.client;

import xcxxx.entity.Order;
import xcxxx.entity.User;
import xcxxx.service.Impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClientOrderListServlet", urlPatterns = "/client/ClientOrderListServlet")
public class ClientOrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            request.setAttribute("message", "对不起，请先登录");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        BusinessServiceImpl service = new BusinessServiceImpl();
        List<Order> orders = service.clientListOrder(userid);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/client/clientorderlist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
