package br.csi.ufsm.Orders.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.csi.ufsm.Orders.model.order.Order;
import br.csi.ufsm.Orders.model.order.OrderRepository;


@Service
public class OrderService {
    
    private OrderRepository repository;

    public OrderService(OrderRepository repository){
        this.repository = repository;
    }

    public void register(Order order){
        this.repository.save(order);
    }

    public List<Order> toList(){
        return this.repository.findAll();
    }

    public Order findById(Long id){
        return this.repository.findById(id).get();
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }
    
}
