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
        return Response.ok("User "+user.getName()+" has bee created").build();

    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/deleteUser")
    public Response deleteUser(User user){
        for(ShopingCart shopingCart: shopingCarts){
            if (shopingCart.getUser().equals(user)){
                shopingCarts.remove(shopingCart);
                return Response.ok("User "+user.getName()+" has been deleted!").build();
            }
        }
        return Response.ok("User not found").build();
    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/takeProducts")
    public Response takeProducts(User user, List<Product> productList){

        if (user==null)return Response.ok("User is null!").build();
        for (ShopingCart shopingCart: shopingCarts){
            if(shopingCart.getUser().equals(user)){
                shopingCart.setProductList(productList);
                return Response.ok("Ok!").build();
            }
        }
        return Response.ok("User not found!").build();
    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/deleteProducts")
    public Response deleteProducts(User user, List<Product> productList){
        if (user==null)return Response.ok("User is null!").build();

        for (ShopingCart shopingCart: shopingCarts){
            if(shopingCart.getUser().equals(user)){
                shopingCart.getProductList().addAll(productList);
                return Response.ok("Ok!").build();
            }
        }

        return Response.ok("User not found!").build();
    }

    @GET
    @Produces("text/plain")
    @Path("/findAllUsers")
    public Response findAllUsers(){
        List<User> users = new LinkedList<User>();
        for (ShopingCart shopingCart: shopingCarts){
            users.add(shopingCart.getUser());
        }
        return Response.ok(users).build();

    }


}


