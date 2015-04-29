package productsdemo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductApp {
    void main(String[] args){
        ClassPathXmlApplicationContext xmlApplicationContext =
                new ClassPathXmlApplicationContext("products-context.xml");
        xmlApplicationContext.close();

    }

}
