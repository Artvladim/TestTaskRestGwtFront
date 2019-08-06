package netcracker.homework.testTask.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products") //класс соответствующий таблице в базе данных
public class ProductDao {

    private Integer id;

    private String productName;

        private Long price;

        private Long shopId;


    Set<ShopDao> shops = new HashSet<>();

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column
    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Column
    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "products_shops",
            joinColumns = { @JoinColumn(name = "product_id") },
            inverseJoinColumns = { @JoinColumn(name = "shop_id") }
    )
    public Set<ShopDao> getShops() {
        return shops;
    }

    public void setShops(Set<ShopDao> shops) {
        this.shops = shops;
    }
}
