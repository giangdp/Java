package br.csi.ufsm.Orders.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private AlunoRepository repository;
    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }
    
}
