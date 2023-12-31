package br.csi.ufsm.Orders.model.order;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotBlank
    private String neighborhood;
    @NotBlank
    private String street;
    @NotBlank
    private String cep;
    @NotBlank
    private String number;
    
}
