package netcracker.homework.testTask.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import netcracker.homework.testTask.dto.ClientDto;

import java.util.List;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

  List<ClientDto> list();

  ClientDto save(ClientDto client);

  Boolean delete(ClientDto client);
}
