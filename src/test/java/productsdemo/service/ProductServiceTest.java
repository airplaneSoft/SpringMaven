package productsdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import productsdemo.beans.Product;
import productsdemo.dao.ProductDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-products-context.xml")
public class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductDao productDao;

    @Test
    public  void testFindById() throws Exception {

        Product p1 = new Product(1, "prod1");
        productDao.create(p1);

        Assert.assertNotNull("Our service is null, dude...", productService);
        Product product = productService.findById(1);

        Assert.assertEquals("prod1", product.getName());

    }





}
