package br.csi.ufsm.Orders.model;

import org.springframework.data.jpa.repository.JpaRepository;

public class ClientRepository  extends JpaRepository <Client, Long>{

    public Client getById(Long id);
    public Optional<Client> findById(Long id);
    
}
