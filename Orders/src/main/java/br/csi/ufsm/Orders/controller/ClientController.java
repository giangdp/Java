package br.csi.ufsm.Orders.controller;

import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;
import jakarta.validation.Valid;

import br.csi.ufsm.Orders.model.order.Client;
import br.csi.ufsm.Orders.service.ClientService;



@RestController
@RequestMapping("/client")
public class ClientController {
    
    private final ClientService service;

    public ClientController(ClientService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Client client(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid Client client, UriComponentsBuilder uriBuilder){

        this.service.register(client);
        URI uri = uriBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> toList(){
        return ResponseEntity.ok(this.service.toList());
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody Client client){
        this.service.update(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}