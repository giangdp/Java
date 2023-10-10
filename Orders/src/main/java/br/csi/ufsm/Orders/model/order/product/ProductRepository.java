package br.csi.ufsm.Orders.model.order.product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

    public Product getById(Long id);
    
}
