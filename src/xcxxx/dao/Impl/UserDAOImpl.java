package xcxxx.dao.Impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import xcxxx.dao.UserDAO;
import xcxxx.entity.User;
import xcxxx.utils.JdbcUtils;

public class UserDAOImpl implements UserDAO{
    @Override
    public void add(User user) {
        try{
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "insert into user(userId,username,password) values(?,?,?)";
            Object params[] = {user.getUserId(),user.getUsername(),user.getPassword()};
            runner.update(sql, params);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User find(String id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where userId=?";
            return (User)runner.query(sql,new BeanHandler(User.class),id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public User find(String username, String password) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where username=? and password=?";
            Object params[] = {username, password};
            return (User)runner.query(sql,new BeanHandler(User.class),params);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
