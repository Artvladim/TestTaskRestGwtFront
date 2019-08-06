package netcracker.homework.testTask.controller;

import netcracker.homework.testTask.dto.ProductDto;
import netcracker.homework.testTask.dto.ShopDto;
import netcracker.homework.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //класс который участвует в мапинге (отвечает за) URLов
@RequestMapping("/product")
public class ProductController {

    @Autowired //не надо создавать экземпляр через new
    private ProductService productService;

    @GetMapping("/retrieveAll")
    ResponseEntity<List<ProductDto>> retrieveAll() {
        return ResponseEntity.ok(productService.retrieveAll());
    }

    @GetMapping("/retrieveById")
    ResponseEntity<List<ProductDto>> retrieveById(@RequestParam Integer id) {
        return ResponseEntity.ok(productService.retrieveByProductId(id));
    }

    @GetMapping("/retrieveShopsByProductId")
    ResponseEntity<List<ShopDto>> retrieveShopsWhereProductsAre(@RequestParam Integer productId) {
        return ResponseEntity.ok(productService.retrieveShopsWhereProductsAre(productId));
    }
}
