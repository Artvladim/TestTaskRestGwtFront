package netcracker.homework.testTask.mapper;

import netcracker.homework.testTask.dao.ProductDao;
import netcracker.homework.testTask.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring") //конвертация dao в dto и обратно
public interface ProductMapper {
    ProductDto mapToDto(ProductDao source);
    ProductDao mapToDao(ProductDto source);

    List<ProductDto> mapCollectionToDto(List<ProductDao> source);
    List<ProductDao> mapCollectionToDao(List<ProductDto> source);
}
