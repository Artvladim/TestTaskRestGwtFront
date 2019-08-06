package netcracker.homework.testTask.controller;

import netcracker.homework.testTask.dto.OrderDto;
import netcracker.homework.testTask.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/retrieveAll")
    ResponseEntity<List<OrderDto>> retrieveAll() {
        return ResponseEntity.ok(orderService.retrieveAll());
    }

    @GetMapping("/retrieveAllWithPriceMoreThan")
    ResponseEntity<List<OrderDto>> retrieveAllWithPriceMoreThan(@RequestParam Integer price) {
        return ResponseEntity.ok(orderService.retrieveAllWithPriceMoreThan(price)); //get запрос на который возвращается ok response
    }

    @GetMapping("/retrieveByOrderId")
    ResponseEntity<List<OrderDto>> retrieveByOrderId(@RequestParam Long order_id) {
        return  ResponseEntity.ok(orderService.retrieveByOrderId(order_id));
    }
}
