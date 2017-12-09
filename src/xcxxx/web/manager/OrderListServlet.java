package xcxxx.web.manager;

import xcxxx.entity.Order;
import xcxxx.service.BusinessService;
import xcxxx.service.Impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderListServlet", urlPatterns = "/manager/OrderListServlet")
public class OrderListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String state = request.getParameter("state");
        BusinessServiceImpl service = new BusinessServiceImpl();
        List<Order> orders = service.listOrder(state);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/manager/orderlist.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
