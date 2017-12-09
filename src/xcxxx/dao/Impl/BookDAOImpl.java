package xcxxx.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import xcxxx.dao.BookDAO;
import xcxxx.entity.Book;
import xcxxx.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class BookDAOImpl implements BookDAO{
    @Override
    public void add(Book book) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into book(id,name,author,price,image,description,category_id) values(?,?,?,?,?,?,?)";
            Object params[] = {book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getImage(), book.getDescription(), book.getCategory_id()};
            runner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book find(String id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from book where id=?";
            return (Book)runner.query(sql, new BeanHandler(Book.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getPageData(int startindex, int pagesize) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from book limit ?,?";
            Object params[] = {startindex, pagesize};
            return (List<Book>)runner.query(sql, new BeanListHandler(Book.class), params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalRecord() {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from book";
            long totalrecord = (Long)runner.query(sql, new ScalarHandler());
            return (int)totalrecord;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> getPageData(int startindex, int pagesize, String category_id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from book where category_id=? limit ?,?";
            Object params[] = {category_id, startindex, pagesize};
            return (List<Book>)runner.query(sql,new BeanListHandler(Book.class),params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalRecord(String category_id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select count(*) from book where category_id=?";
            long totalrecord = (Long)runner.query(sql, new ScalarHandler(),category_id);
            return (int)totalrecord;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
