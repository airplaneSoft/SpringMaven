package productsdemo.service;

import productsdemo.beans.Product;

public interface ProductService {
    Product findById(Integer id);
}
