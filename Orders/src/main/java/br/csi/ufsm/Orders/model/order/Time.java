package br.csi.ufsm.Orders.model.order;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Table(name = "time")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Time {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_time;
    private Data data;
}
