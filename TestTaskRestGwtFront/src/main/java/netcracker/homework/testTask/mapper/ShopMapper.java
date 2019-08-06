package netcracker.homework.testTask.mapper;

import netcracker.homework.testTask.dao.ShopDao;
import netcracker.homework.testTask.dto.ShopDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring") //конвертация dao в dto и обратно
public interface ShopMapper {
    ShopDto mapToDto(ShopDao source);
    ShopDao mapToDao(ShopDto source);

    List<ShopDto> mapCollectionToDto(List<ShopDao> source);
    List<ShopDao> mapCollectionToDao(List<ShopDto> source);
}
