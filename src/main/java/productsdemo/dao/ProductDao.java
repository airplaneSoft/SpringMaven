package productsdemo.dao;

import productsdemo.beans.Product;

import java.util.Collection;

public interface ProductDao {
    Product findById(Integer id);
    void create(Product product);
    void update(Product product);
    void delete(Integer id);
    Collection<Product> findAll();
}
