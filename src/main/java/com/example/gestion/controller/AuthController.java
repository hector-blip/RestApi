package com.example.gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.example.gestion.model.Utilisateur;
import com.example.gestion.services.UtilisateurService;
// import com.example.gestion.util.JwtTokenProvider;
import com.example.gestion.util.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/login")
    public String authenticateUser(@RequestBody Utilisateur loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getUserPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return tokenProvider.generateToken(authentication);
    }

    @PostMapping("/register")
    public Utilisateur registerUser(@RequestBody Utilisateur signUpRequest) {
        signUpRequest.setUserPassword(passwordEncoder.encode(signUpRequest.getUserPassword()));
        return utilisateurService.createUtilisateur(signUpRequest);
    }
}
