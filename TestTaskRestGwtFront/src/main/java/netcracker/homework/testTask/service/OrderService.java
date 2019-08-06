package netcracker.homework.testTask.service;

import netcracker.homework.testTask.dao.OrderDao;
import netcracker.homework.testTask.dto.OrderDto;
import netcracker.homework.testTask.mapper.OrderMapper;
import netcracker.homework.testTask.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //вся бизнес-логика (все алгоритмика)
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> retrieveAll() {
        List<OrderDao> orderDaoList = orderRepository.findAll();
        return orderMapper.mapCollectionToDto(orderDaoList);
    }

    public List<OrderDto> retrieveByOrderId(Long order_id) {
        List<OrderDao> orderDaoList = orderRepository.findAll();

        List<OrderDao> filteredOrdersById = new ArrayList<>();
        for (OrderDao orderDao : orderDaoList) {
            if (orderDao.getId() == order_id) {
                filteredOrdersById.add(orderDao);
            }
        }

        return orderMapper.mapCollectionToDto(filteredOrdersById); //преобразование данных из таблицы в json (мапинг dao в dto)
    }

    public List<OrderDto> retrieveByClientId(Integer client_id) {
        List<OrderDao> orderDaoList = orderRepository.findAll();

        List<OrderDao> filteredOrdersByClientId = new ArrayList<>();
        for (OrderDao orderDao : orderDaoList) {
            if (orderDao.getClientId() == client_id) {
                filteredOrdersByClientId.add(orderDao);
            }
        }

        return orderMapper.mapCollectionToDto(filteredOrdersByClientId);
    }

    public List<OrderDto> retrieveAllWithPriceMoreThan(Integer price) {
        List<OrderDao> orderDaoList = orderRepository.findAll();

        List<OrderDao> filteredOrders = new ArrayList<>();
        for (OrderDao orderDao : orderDaoList) {
            if (orderDao.getPrice() >= price) {
                filteredOrders.add(orderDao);
            }
        }

        return orderMapper.mapCollectionToDto(filteredOrders);
    }
}
