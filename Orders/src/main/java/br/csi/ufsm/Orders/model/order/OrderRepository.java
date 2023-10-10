package br.csi.ufsm.Orders.model.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

    public Order getById(Long id);
    
}
