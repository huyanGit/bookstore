package xcxxx.dao;

import xcxxx.entity.Category;

import java.util.List;

public interface CategoryDAO {
    public abstract void add(Category category);
    public abstract Category find(String id);
    public List<Category> getAll();
}
