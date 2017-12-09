package xcxxx.web.client;

import xcxxx.entity.Category;
import xcxxx.entity.Page;
import xcxxx.service.Impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/client/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if(method.equalsIgnoreCase("getAll")){
            getAll(request, response);
        }else if(method.equalsIgnoreCase("bookListWithCategory")){
            bookListWithCategroy(request, response);
        }
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        BusinessServiceImpl service = new BusinessServiceImpl();
        List<Category> categories = service.getAllCategory();
        request.setAttribute("categories",categories);
        String pagenum = request.getParameter("pagenum");
        Page page = service.getBookPageData(pagenum);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/client/body.jsp").forward(request, response);
        //response.sendRedirect(request.getContextPath()+"/client/main.jsp");
    }
    public void bookListWithCategroy(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        BusinessServiceImpl service = new BusinessServiceImpl();
        List<Category> categories = service.getAllCategory();
        request.setAttribute("categories",categories);

        String category_id = request.getParameter("category_id");
        String pagenum = request.getParameter("pagenum");
        Page page = service.getBookPageData(pagenum, category_id);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/client/body.jsp").forward(request, response);
        //response.sendRedirect(request.getContextPath()+"/client/main.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
