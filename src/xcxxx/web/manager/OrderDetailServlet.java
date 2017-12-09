package xcxxx.web.manager;

import xcxxx.entity.Order;
import xcxxx.service.Impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderDetailServlet", urlPatterns = "/manager/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderid = request.getParameter("orderid");
        BusinessServiceImpl service = new BusinessServiceImpl();
        Order order = service.findOrder(orderid);
        request.setAttribute("order", order);
        request.getRequestDispatcher("/manager/orderdetail.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
