package netcracker.homework.testTask.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class ShopDto {
    @NotBlank
    @Length(min = 1, max = 5, message = "Id магазина от 1 до 5")
    private Integer id;

    @NotBlank
    @Length(min = 1, max = 20, message = "Название магазина от 1 до 20")
    private String shopName;

    @NotBlank
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
