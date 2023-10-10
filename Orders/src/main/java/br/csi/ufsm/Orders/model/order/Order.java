package br.csi.ufsm.Orders.model.order;

import br.csi.ufsm.Orders.model.order.client.Client;
import br.csi.ufsm.Orders.model.order.product.Product;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_order;
    @Embedded
    private Client client;
    @Embedded
    private Address address;
    @Embedded
    private Product product;
    @Embedded
    private Time time;
    
}
