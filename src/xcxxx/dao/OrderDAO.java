package xcxxx.dao;

import xcxxx.entity.Order;
import xcxxx.entity.User;

import java.util.List;

public interface OrderDAO {
    void add(Order order);
    Order find(String id);
    List<Order> getAll(boolean state);
    void update(Order order);
    List<Order> getAll(boolean state, String userid);
    List<Order> getAllOrder(String userid);
}
