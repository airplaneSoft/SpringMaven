package productsdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import productsdemo.beans.Product;
import productsdemo.beans.ShopingCart;
import productsdemo.beans.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
@Path("/user")
public class UserApi {


    private ArrayList<ShopingCart> shopingCarts = new ArrayList<ShopingCart>();

    //createUser, deleteUser, takeProducts, deleteProducts,findAllUsers
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/createUser")
    public Response createUser(User user){
        ShopingCart s = new ShopingCart();
        s.setUser(user);
        shopingCarts.add(s);
        return Response.ok("User "+user.getName()+" has been created!!!").build();

    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/deleteUser")
    public Response deleteUser(User user){
        for(ShopingCart shopingCart: shopingCarts){

            if (shopingCart.getUser().getName().equals(user.getName())){
                shopingCarts.remove(shopingCart);
                return Response.ok("User "+user.getName()+" has been deleted!").build();
            }
        }
        return Response.ok("User not foundd!").build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/takeProducts")
    //public Response takeProducts(List<Object> list){
    public Response takeProducts(Map<String,Object> userListMap){
        String name=null;
        ArrayList<ShopingCart> s = new ArrayList<ShopingCart>();
        for (Map.Entry entry: userListMap.entrySet()){

            if((entry.getKey()).equals("name")) {
                name = (String) entry.getValue();
                continue;
            }
            for(ShopingCart shopingCart: shopingCarts){
                if (shopingCart.getUser().getName().equals(name)){
                    shopingCart.setProductList((List<Product>) entry.getValue());
                    s.add(shopingCart);
                }else {
                    return Response.ok("Data ERROR").build();
                }
            }
        }
        return Response.ok(s).build();
    }


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/deleteProducts")
    public Response deleteProducts(Map<String,Object> userListMap){

        String name=null;
        ArrayList<ShopingCart> s = new ArrayList<ShopingCart>();
        for (Map.Entry entry: userListMap.entrySet()){

            if((entry.getKey()).equals("name")) {
                name = (String) entry.getValue();
                continue;
            }
            for(ShopingCart shopingCart: shopingCarts){
                if (shopingCart.getUser().getName().equals(name)){
                    shopingCart.getProductList().removeAll((List<Product>) entry.getValue());
                    s.add(shopingCart);
                }else {
                    return Response.ok("Data ERROR").build();
                }
            }

        }

        return Response.ok(s).build();
    }

    @GET
    @Produces("application/json")
    @Path("/findAllUsers")
    public Response findAllUsers(){
        List<User> users = new LinkedList<User>();
        for (ShopingCart shopingCart: shopingCarts){
            users.add(shopingCart.getUser());
        }
        return Response.ok(users).build();

    }



}


