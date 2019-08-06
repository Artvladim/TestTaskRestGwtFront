package netcracker.homework.testTask.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class ProductDto {
    @NotBlank
    private Integer id;

    @NotBlank
    @Length(min = 1, max = 20, message = "Длина названия продукта от 1 до 20")
    private String productName;

    @NotBlank
    private Long price;

    @NotBlank
    private Long shopId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
