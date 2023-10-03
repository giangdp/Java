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
    private String neightborhood;
    @NotBlank
    private String street;
    @NotBlank
    private String cep;
    @NotBlank
    private String number;
    @NotBlank
    private String city;

    
}
