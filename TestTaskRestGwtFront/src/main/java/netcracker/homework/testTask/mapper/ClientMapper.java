package netcracker.homework.testTask.mapper;

import netcracker.homework.testTask.dao.ClientDao;
import netcracker.homework.testTask.dto.ClientDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring") //конвертация dao в dto и обратно
public interface ClientMapper {
   ClientDto mapToDto(ClientDao source);
   ClientDao mapToDao(ClientDto source);

   List<ClientDto> mapCollectionToDto(List<ClientDao> source);
   List<ClientDao> mapCollectionToDao(List<ClientDto> source);
}
