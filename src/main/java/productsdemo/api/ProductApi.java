package productsdemo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import productsdemo.beans.Product;
import productsdemo.dao.ProductDao;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Component
@Path("/product")
public class ProductApi {

    @Autowired
    private ProductDao productDao;

    //TODO delete, findAll, update

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/create")
    public Response create(Product product) {

        productDao.create(product);
        return Response.ok("Created").build();

    }



    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/delete")
    public Response delete(Integer id) {

        productDao.delete(id);
        return Response.ok("Deleted").build();

    }
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    @Path("/update")
    public Response update(Product product) {

        productDao.update(product);
        return Response.ok("Product has been update").build();

    }

    @GET
    @Produces("application/json")
    @Path("/get")
    public Response findProductById(@QueryParam("id")Integer id) {

        Product product = productDao.findById(id);

        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Not found").build();
        }
        return Response.ok(product).build();
    }
    @GET
    @Produces("application/json")
    @Path("/findAll")
    public Response findAll(){

        Collection<Product> products = productDao.findAll();

        return Response.ok(products).build();
    }

}
