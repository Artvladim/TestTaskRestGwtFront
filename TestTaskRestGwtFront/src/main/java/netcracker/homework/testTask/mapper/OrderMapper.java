package netcracker.homework.testTask.mapper;

import netcracker.homework.testTask.dao.OrderDao;
import netcracker.homework.testTask.dto.OrderDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring") //конвертация dao в dto и обратно
public interface OrderMapper {
    OrderDto mapToDto(OrderDao source);
    OrderDao mapToDao(OrderDto source);

    List<OrderDto> mapCollectionToDto(List<OrderDao> source);
    List<OrderDao> mapCollectionToDao(List<OrderDto> source);
}
