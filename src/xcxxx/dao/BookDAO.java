package xcxxx.dao;

import xcxxx.entity.Book;

import java.util.List;

public interface BookDAO {
    void add(Book book);
    Book find(String id);
    List<Book> getPageData(int startindex, int pagesize);
    int getTotalRecord();
    List<Book> getPageData(int startindex, int pagesize, String category_id);
    int getTotalRecord(String category_id);
}
