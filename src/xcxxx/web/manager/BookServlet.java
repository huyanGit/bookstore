package xcxxx.web.manager;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import xcxxx.entity.Book;
import xcxxx.entity.Category;
import xcxxx.entity.Page;
import xcxxx.service.BusinessService;
import xcxxx.service.Impl.BusinessServiceImpl;
import xcxxx.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "BookServlet",urlPatterns = "/manager/BookServlet")
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if("list".equals(method)){
            String pagenum = request.getParameter("pagenum");
            BusinessServiceImpl service = new BusinessServiceImpl();
            Page page = service.getBookPageData(pagenum);
            request.setAttribute("page", page);
            request.getRequestDispatcher("/manager/booklist.jsp").forward(request, response);
        }else if("add".equals(method)){
            try {
                Book book = upload(request);
                BusinessService service = new BusinessServiceImpl();
                book.setId(WebUtils.makeID());
                service.addBook(book);
                request.setAttribute("message","添加成功");
            }catch (Exception e){
                e.printStackTrace();
                request.setAttribute("message", "添加失败");
            }
            request.getRequestDispatcher("/message.jsp").forward(request,response);
        }else if("addUI".equals(method)){
            BusinessService service = new BusinessServiceImpl();
            List<Category> categories = service.getAllCategory();
            request.setAttribute("categories", categories);
            request.getRequestDispatcher("/manager/addbook.jsp").forward(request, response);
        }
    }
    private Book upload(HttpServletRequest request){
        Book book = new Book();
        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            // 使用ServletFileUpload解析器解析上传数据，
            // 解析结果返回的是一个List<FileItem>集合，
            // 每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for(FileItem item : list){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    BeanUtils.setProperty(book,name,value);
                }else{
                    String filename = item.getName();
                    String savefilename = makeFileName(filename);
                    //String savepath = this.getServletContext().getRealPath("/images");
                    String savepath = "/Users/kohiko/IdeaProjects/bookstore/web/images";
                    System.out.println(savepath);
                    InputStream in = item.getInputStream();
                    FileOutputStream out = new FileOutputStream(savepath+"/"+savefilename);
                    int len = 0;
                    byte buffer[] = new byte[1024];
                    while((len=in.read(buffer))>0){
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                    item.delete();
                    book.setImage(savefilename);
                    System.out.println(book.getImage());
                }
            }
            return book;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public String makeFileName(String filename){
        String ext = filename.substring(filename.lastIndexOf(".")+1);
        return UUID.randomUUID().toString() + "." + ext;
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
