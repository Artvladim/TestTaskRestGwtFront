package netcracker.homework.testTask.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shops")
public class ShopDao {

    private Long id;

    private String shopName;

    private String address;



    private Set<ProductDao> products = new HashSet<>();

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Column
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @ManyToMany(mappedBy = "shops")
    public Set<ProductDao> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductDao> products) {
        this.products = products;
    }
}
