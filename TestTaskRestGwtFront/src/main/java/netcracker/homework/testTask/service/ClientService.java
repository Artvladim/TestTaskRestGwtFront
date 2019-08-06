package netcracker.homework.testTask.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import netcracker.homework.testTask.client.GreetingService;
import netcracker.homework.testTask.dao.ClientDao;
import netcracker.homework.testTask.dto.ClientDto;
import netcracker.homework.testTask.mapper.ClientMapper;
import netcracker.homework.testTask.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service //вся бизнес-логика (все алгоритмика)
public class ClientService extends RemoteServiceServlet
        implements GreetingService, Serializable {

    private final ClientRepository clients = AppContext.getBean(ClientRepository.class);


    @Override
    public List<ClientDto> list() {
        List<ClientDto> clients = new ArrayList<>();
        for (ClientDao client : this.clients.findAll()) {
            clients.add(new ClientDto());
        }
        return clients;
    }

    @Override
    public ClientDto save(ClientDto data) {
        ClientDao client = new ClientDao();
        if (data.getId() !=-1) {
            client.setId(data.getId());
        }
        client.setName(data.getName());
        client.setSureName(data.getSureName());
        client.setGender(data.getGender());
        client.setAge(data.getAge());

        this.clients.save(client);
        data.setId(client.getId());
        System.out.println("DATA = " + data);
        System.out.println("ORDER ID = " + client.getId());
        for (ClientDao p : clients.findAll()) {
            System.out.println("OrderRepository = " + p);
        }
        return data;
    }

    @Override
    public Boolean delete(ClientDto data) {
        this.clients.delete(data.getId());
        return true;
    }


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public List<ClientDto> retrieveAll() {
        List<ClientDao> clientDaoList = clientRepository.findAll();
        return clientMapper.mapCollectionToDto(clientDaoList);
    }

    public List<ClientDto> retrieveByName(String clientName) {
        return clientMapper.mapCollectionToDto(clientRepository.findByName(clientName));
    }

    public List<ClientDto> retrieveByAge(Integer clientAge) {
        return clientMapper.mapCollectionToDto(clientRepository.findByAge(clientAge));
    }

    //public List<ClientDto> retrieveAllWithAgeMoreThan(Integer age) {
    //List<ClientDao> clientDaoList = clientRepository.findAll();

    //List<ClientDao> filteredClients = new ArrayList<>();
    //for (ClientDao clientDao : clientDaoList) {
     //  if (clientDao.getAge() >= age) {
      //   filteredClients.add(clientDao);
 //    }
   //  }

   //   return clientMapper.mapCollectionToDto(filteredClients); //преобразование данных из таблицы в json (мапинг dao в dto)
    // }
   }
