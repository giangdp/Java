package br.csi.ufsm.Orders.service;

import org.springframework.stereotype.Service;

import br.csi.ufsm.Orders.model.order.Client;
import br.csi.ufsm.Orders.model.order.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository repository;

    public ClientService(ClientRepository repository){
        this.repository = repository;
    }

    public void register(Client client){
        this.repository.save(client);
    }

    public List<Client> toList(){
        return this.repository.findAll();
    }

    public Client findById(Long id){
        return this.repository.findById(id).get();
    }

    public void update(Client client){
        Client c = this.repository.getReferenceById(client.getId());
        c.setName(client.getName());
        c.setEmail(client.getEmail());
        c.setCellphone_number(client.getCellphone_number());
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }
    
}
