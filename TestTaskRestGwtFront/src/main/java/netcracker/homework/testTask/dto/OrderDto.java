package netcracker.homework.testTask.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class OrderDto {

    @NotBlank(message = "ID ордера не должно быть пустым")
    @Length(min = 1, max = 5, message = "Длина ID ордера от 1 до 5 символов")
    private Long id;

    @NotBlank(message = "ID клиента не должно быть пустым")
    @Length(min = 1, max = 5, message = "Длина ID клиента от 1 до 5 символов")
    private Integer clientId;

    @NotBlank(message = "ID магазина не должно быть пустым")
    @Length(min = 1, max = 5, message = "Длина ID магазина от 1 до 5 символов")
    private Integer shopId;

    @NotBlank(message = "ID продукта не должно быть пустым")
    @Length(min = 1, max = 5, message = "Длина ID продукта от 1 до 5 символов")
    private Integer productId;

    @NotBlank(message = "Цена не должна быть пустой")
    @Min(value = 55, message = "Минимальная цена продукции = 55 рублей")
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
