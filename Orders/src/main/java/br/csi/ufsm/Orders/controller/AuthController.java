package br.csi.ufsm.Orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.csi.ufsm.Orders.model.user.AuthDTO;
import br.csi.ufsm.Orders.model.user.LoginResponseDTO;
import br.csi.ufsm.Orders.model.user.RegisterDTO;
import br.csi.ufsm.Orders.model.user.User;
import br.csi.ufsm.Orders.model.user.UserRepository;
import br.csi.ufsm.Orders.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encrypPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encrypPassword, data.role());

        this.repository.save(newUser);
        return ResponseEntity.ok().build();

    }
    
}
