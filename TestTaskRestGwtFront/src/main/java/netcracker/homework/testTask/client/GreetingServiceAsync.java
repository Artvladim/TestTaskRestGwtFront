package netcracker.homework.testTask.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import netcracker.homework.testTask.dto.ClientDto;

import java.util.List;

public interface GreetingServiceAsync {
    void list(AsyncCallback<List<ClientDto>> async);

    void save(ClientDto client, AsyncCallback<ClientDto> async);

    void delete(ClientDto client, AsyncCallback<Boolean> async);
}
