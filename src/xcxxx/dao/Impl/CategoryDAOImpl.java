package xcxxx.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import xcxxx.dao.CategoryDAO;
import xcxxx.entity.Category;
import xcxxx.utils.JdbcUtils;

import java.sql.SQLException;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO{
    @Override
    public void add(Category category) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into category(id,name,description) values(?,?,?)";
            Object params[] = {category.getId(), category.getName(), category.getDescription()};
            runner.update(sql, params);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Category find(String id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from category where id=?";
            return (Category)runner.query(sql, new BeanHandler(Category.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Category> getAll() {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from category";
            return (List<Category>)runner.query(sql, new BeanListHandler(Category.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
