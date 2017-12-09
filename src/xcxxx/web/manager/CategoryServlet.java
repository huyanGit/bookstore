package xcxxx.web.manager;

import xcxxx.entity.Category;
import xcxxx.service.BusinessService;
import xcxxx.service.Impl.BusinessServiceImpl;
import xcxxx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet",urlPatterns = "/manager/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("listall".equals(method)){
            BusinessService service = new BusinessServiceImpl();
            List<Category> categories = service.getAllCategory();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/manager/categorylist.jsp").forward(request,response);
        }else if("add".equals(method)){
            try {
                String name = request.getParameter("name");
                String description = request.getParameter("description");
                Category category = new Category();
                category.setId(WebUtils.makeID());
                category.setName(name);
                category.setDescription(description);
                BusinessService service = new BusinessServiceImpl();
                service.addCategory(category);
                request.setAttribute("message", "添加成功");
            }catch (Exception e){
                e.printStackTrace();
                request.setAttribute("message","添加失败");
            }
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
