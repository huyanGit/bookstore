package xcxxx.web.client;

import xcxxx.entity.Book;
import xcxxx.entity.Cart;
import xcxxx.service.Impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BuyServlet", urlPatterns = "/client/BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String bookid = request.getParameter("bookid");
            BusinessServiceImpl service = new BusinessServiceImpl();
            Book book = service.findBook(bookid);
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if(cart==null){
                cart = new Cart();
                request.getSession().setAttribute("cart",cart);
            }
            service.buyBook(cart, book);
            request.getRequestDispatcher("/client/cartlist.jsp").forward(request,response);
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message","购买失败");
            request.getRequestDispatcher("message.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
