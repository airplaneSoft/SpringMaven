package productsdemo.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import productsdemo.beans.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-products-context.xml")

public class HibernateProductDaoTest {

    @Autowired
    ProductDao productDao;


    @Before
    public void fillDb(){

        Product p1 = new Product(1, "prod1");
        Product p2 = new Product(2, "prod2");
        Product p3 = new Product(3, "prod3");

        productDao.create(p1);
        productDao.create(p2);
        productDao.create(p3);

    }

    @Test
    public  void testFindById(){

        Assert.assertNotNull(productDao);
        Product pr = productDao.findById(1);
        Assert.assertEquals("prod1",pr.getName());
    }

    @Test
    public void testCreate() {

        Product p = new Product(4, "prod4");
        productDao.create(p);
        Assert.assertNotNull(productDao.findById(4));

    }


    @Test
    public void testUpdate() {

        Product p = productDao.findById(1);
        p.setName("asdasd");
        productDao.update(p);

        Assert.assertEquals("asdasd", productDao.findById(1).getName());

    }

    @Test
    public void testDelete() {
        productDao.delete(1);
        Assert.assertNull(productDao.findById(1));
    }






}
