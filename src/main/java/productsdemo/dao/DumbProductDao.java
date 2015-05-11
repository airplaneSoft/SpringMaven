package productsdemo.dao;


import productsdemo.beans.Product;
import productsdemo.dao.ProductDao;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//@Repository
public class DumbProductDao implements ProductDao
{

    private Map<Integer, Product> productMap = new ConcurrentHashMap<Integer, Product>();

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void create(Product product) {
        productMap.put(product.getId(),product);
    }

    @Override
    public void update(Product product) {
        if (productMap.get(product.getId()) == null) {
            throw new RuntimeException();
        } else {
            productMap.put(product.getId(), product);
        }
    }

    @Override
    public void delete(Integer id) {
        productMap.remove(id);
    }

    @Override
    public Collection<Product> findAll() {
        return productMap.values();
    }
}
