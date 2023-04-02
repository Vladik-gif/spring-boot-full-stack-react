package uk.vladik.api.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.vladik.api.api.service.ClientService;
import uk.vladik.api.store.entity.ClientEntity;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    private static final String UPDATE = "/{id}";
    private static final String GET_ID = "/{id}";
    private static final String DELETE_ID = "/{id}";


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ClientEntity client){
        return clientService.create(client);
    }

    @PutMapping(UPDATE)
    public ResponseEntity update(@PathVariable Long id, @RequestBody ClientEntity client){
        return clientService.updateClient(id, client);
    }

    @GetMapping(GET_ID)
    public ClientEntity getId(@PathVariable Long id){
        return clientService.getClient(id);
    }

    @GetMapping
    public List<ClientEntity> getAll(){
        return clientService.getClients();
    }

    @DeleteMapping(DELETE_ID)
    public ResponseEntity deleteId(@PathVariable Long id){
        return clientService.deleteClient(id);
    }
}
