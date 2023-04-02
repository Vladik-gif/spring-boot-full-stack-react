package uk.vladik.api.api.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uk.vladik.api.store.entity.ClientEntity;
import uk.vladik.api.store.repository.ClientRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity create(ClientEntity client) {
        ClientEntity clientEntity = clientRepository.save(client);
        try {
            return ResponseEntity.created(new URI("/clients/" + clientEntity.getId())).body(clientEntity);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity updateClient(Long id, ClientEntity client) {
        ClientEntity currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);

        currentClient.setUsername(client.getUsername());
        currentClient.setEmail(client.getEmail());

        currentClient = clientRepository.save(client);

        return ResponseEntity.ok(currentClient);
    }

    public List<ClientEntity> getClients() {
        return clientRepository.findAll();
    }

    public ClientEntity getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(RuntimeException::new);
    }


    public ResponseEntity deleteClient(Long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
