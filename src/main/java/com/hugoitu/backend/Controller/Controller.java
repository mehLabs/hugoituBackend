/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import org.json.JSONException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugoitu.backend.Service.JwtUserDetailsService;
import com.hugoitu.backend.Security.JwtTokenUtil;
import com.hugoitu.backend.Model.JwtRequest;
import com.hugoitu.backend.Model.JwtResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author hugos
 */
@RestController
@CrossOrigin()
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private JwtUserDetailsService userDetailsService;
    
    
    //Endpoints for testing integration
    @GetMapping("/public/test")
    public String test(){
        System.out.println("test autorizado");
        return "hola mundo!";
    }
    
    @PostMapping("/public/test")
    public String test(@RequestBody String json){
        System.out.println(json);
        return json;
    }
    
    @GetMapping("/protected/test")
    public String privateTest(){
        return "hola mundo privado!";
    }
    
    @PostMapping("/protected/test")
    public Object privateTest(@RequestBody String message) throws JSONException, JsonProcessingException {
        Map<String,Object> mappedJson = new ObjectMapper().readValue(message, HashMap.class); //Convertimos el JSON en un mapa
        mappedJson.put("__test-status", "approved"); //Le agregamos una llave y un valor
        
        try{
            String json = new ObjectMapper().writeValueAsString(mappedJson); //Convertimos el nuevo mapa en un Json
            return json; //Devolvemos el Json
        }catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        
        return "test-status, failed"; //Mensaje de error nunca alcanzado.
    }
    
    ///Lógica real
    @PostMapping("/public/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService
                            .loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);
            

            return ResponseEntity.ok(new JwtResponse(token));
    }
    
    @GetMapping("/private/isAuth")
    public boolean isAuth(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        
        return SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
                //when Anonymous Authentication is enabled
                !(SecurityContextHolder.getContext().getAuthentication()
                         instanceof AnonymousAuthenticationToken) ;
    }
    
    private void authenticate(String username, String password) throws Exception {
		try {
                        
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
    }
}
