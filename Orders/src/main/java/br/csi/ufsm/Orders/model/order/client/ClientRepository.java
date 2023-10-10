package br.csi.ufsm.Orders.model.order.client;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository  extends JpaRepository <Client, Long>{

    public Client getById(Long id);
    public Optional<Client> findById(Long id);

    
}
