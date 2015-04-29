package productsdemo.beans;


import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Generated("default")
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    public Product() {name=null;}

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "id="+id+" name="+name;
    }
}
