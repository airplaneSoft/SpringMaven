package productsdemo.beans;


import java.util.List;

public class ShopingCart {

    private User user;
    private List<Product> productList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
