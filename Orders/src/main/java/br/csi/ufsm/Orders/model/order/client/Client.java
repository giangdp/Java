package br.csi.ufsm.Orders.model.order.client;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;
    @NotBlank
    private String cpf;
    @NotBlank
    private String name;
    @Email(message = "Email inválido")
    private String email;
    @NotBlank
    private String cellphone_number;

    
}
