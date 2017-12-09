package xcxxx.service.Impl;

import xcxxx.dao.BookDAO;
import xcxxx.dao.CategoryDAO;
import xcxxx.dao.Impl.BookDAOImpl;
import xcxxx.dao.Impl.CategoryDAOImpl;
import xcxxx.dao.Impl.OrderDAOImpl;
import xcxxx.dao.Impl.UserDAOImpl;
import xcxxx.dao.OrderDAO;
import xcxxx.dao.UserDAO;
import xcxxx.entity.*;
import xcxxx.service.BusinessService;
import xcxxx.utils.WebUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BusinessServiceImpl implements BusinessService{
    UserDAO userDao = new UserDAOImpl();
    BookDAO bookDao = new BookDAOImpl();
    CategoryDAO categoryDao = new CategoryDAOImpl();
    OrderDAO orderDao = new OrderDAOImpl();
    //注册用户
    @Override
    public void registerUser(User user) {
        userDao.add(user);
    }
    //通过id查找用户
    @Override
    public User findUser(String id){
        return userDao.find(id);
    }
    //用户登录
    @Override
    public User userLogin(String username, String password){
        return userDao.find(username, password);
    }
    //添加书
    @Override
    public void addBook(Book book){
        bookDao.add(book);
    }
    //通过id查找书
    @Override
    public Book findBook(String id){
        return bookDao.find(id);
    }
    //添加分类
    @Override
    public void addCategory(Category category) {
        categoryDao.add(category);
    }
    //获取所有分类
    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAll();
    }
    //通过id查找分类
    @Override
    public Category findCategory(String id) {
        return categoryDao.find(id);
    }
    //获取一页数据
    @Override
    public Page getBookPageData(String pagenum) {
        int totalrecord = bookDao.getTotalRecord();
        Page page = null;
        if(pagenum == null){
            page = new Page(1,totalrecord);
        }else {
            page = new Page(Integer.parseInt(pagenum),totalrecord);
        }
        List<Book> list = bookDao.getPageData(page.getStartindex(),page.getPagesize());
        page.setList(list);
        return page;
    }
    //获取指定分类的一页数据
    @Override
    public Page getBookPageData(String pagenum, String category_id) {
        int totalrecord = bookDao.getTotalRecord(category_id);
        Page page = null;
        if(pagenum == null){
            page = new Page(1,totalrecord);
        }else {
            page = new Page(Integer.parseInt(pagenum), totalrecord);
        }
        List<Book> list = bookDao.getPageData(page.getStartindex(),page.getPagesize(),category_id);
        page.setList(list);
        return page;
    }

    @Override
    public void buyBook(Cart cart, Book book) {
        cart.add(book);
    }

    public void createOrder(Cart cart, User user){
        if(cart == null){
            throw new RuntimeException("对不起，您还没有购买任何商品");
        }
        Order order = new Order();
        order.setId(WebUtils.makeID());
        order.setOrdertime(new Date());
        order.setState(false);
        order.setPrice(cart.getPrice());
        order.setUser(user);
        for(Map.Entry<String, CartItem> me : cart.getMap().entrySet()){
            CartItem cartItem = me.getValue();
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setId(WebUtils.makeID());
            orderItem.setQuantity(cartItem.getQuantity());
            order.getOrderitems().add(orderItem);
        }
        orderDao.add(order);
    }
    //后台获取所有订单信息
    public List<Order> listOrder(String state) {
        return orderDao.getAll(Boolean.parseBoolean(state));
    }

    //列出订单明细
    public Order findOrder(String orderid) {
        return orderDao.find(orderid);
    }

    //把订单置为发货状态
    public void confirmOrder(String orderid) {
        Order order = orderDao.find(orderid);
        order.setState(true);
        orderDao.update(order);
    }

    //获得某个用户的订单信息
    public List<Order> listOrder(String state, String userid) {
        return orderDao.getAll(Boolean.parseBoolean(state), userid);
    }

    //获取某个用户的订单信息
    public List<Order> clientListOrder(String userid) {
        return orderDao.getAllOrder(userid);
    }
}
