package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
// org.hibernate.service.ServiceRegistryBuilder;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import productsdemo.beans.Product;
import productsdemo.service.ProductServiceImpl;


public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static final Logger LOG = LoggerFactory.getLogger(SessionFactory.class);
    static {
        try {
            //creates the session factory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
           LOG.info("session"+sessionFactory);
           /* Configuration configuration = new Configuration().addClass(Product.class);
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}