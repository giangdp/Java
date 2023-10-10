package br.csi.ufsm.Orders.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.csi.ufsm.Orders.model.order.Order;
import br.csi.ufsm.Orders.service.OrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;
    public OrderController(OrderService service){
        this.service=service;
    }

    @GetMapping("/{id}")
    public Order order(@PathVariable Long id){
        return this.service.findById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid Order order, UriComponentsBuilder uriBuilder){

        this.service.register(order);
        URI uri = uriBuilder.path("/order/{id}").buildAndExpand(order.getId_order()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> toList(){
        return ResponseEntity.ok(this.service.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
