package xcxxx.service;

import xcxxx.entity.*;

import java.util.List;

public interface BusinessService {
    public void registerUser(User user);
    public User findUser(String id);
    public User userLogin(String username, String password);
    public void addCategory(Category category);
    public List<Category> getAllCategory();
    public Book findBook(String id);
    public void addBook(Book book);
    public Category findCategory(String id);
    public Page getBookPageData(String pagenum);
    public Page getBookPageData(String pagenum, String category_id);
    public void buyBook(Cart cart, Book book);
}
