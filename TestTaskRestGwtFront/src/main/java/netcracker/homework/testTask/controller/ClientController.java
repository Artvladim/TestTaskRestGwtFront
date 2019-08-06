package netcracker.homework.testTask.controller;

import netcracker.homework.testTask.dto.ClientDto;
import netcracker.homework.testTask.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/retrieveAll")
    ResponseEntity<List<ClientDto>> retrieveAll() {
        return ResponseEntity.ok(clientService.retrieveAll());
    }

    //@GetMapping("/retrieveAllWithAgeMoreThan")
    //ResponseEntity<List<ClientDto>> retrieveAllWithAgeMoreThan(@RequestParam Integer clientAge) {
    //    return ResponseEntity.ok(clientService.retrieveAllWithAgeMoreThan(clientAge)); //get запрос на который возвращается ok response
    //}

    @GetMapping("/retrieveByName")
    ResponseEntity<List<ClientDto>> retrieveByName(@RequestParam String clientName) {
        return  ResponseEntity.ok(clientService.retrieveByName(clientName));
    }

    @GetMapping("/retrieveByAge")
    ResponseEntity<List<ClientDto>> retrieveByAge(@RequestParam Integer clientAge) {
        return  ResponseEntity.ok(clientService.retrieveByAge(clientAge));
    }
}
