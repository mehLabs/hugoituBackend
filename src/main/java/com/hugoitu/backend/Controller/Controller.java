/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.hugoitu.backend.DTO.DatosDTO;
import com.hugoitu.backend.Model.Domicilio;
import com.hugoitu.backend.Model.Educacion;
import com.hugoitu.backend.Model.Experiencia_Laboral;
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
import com.hugoitu.backend.Model.Persona;
import com.hugoitu.backend.Model.Proyecto;
import com.hugoitu.backend.Model.Tecnologia;
import com.hugoitu.backend.Service.IDomicilioServicio;
import com.hugoitu.backend.Service.IEducacionServicio;
import com.hugoitu.backend.Service.IEnlaceServicio;
import com.hugoitu.backend.Service.IExperienciaLaboralServicio;
import com.hugoitu.backend.Service.IPersonaServicio;
import com.hugoitu.backend.Service.IProyectoServicio;
import com.hugoitu.backend.Service.ITecnologiaServicio;
import com.nimbusds.jose.shaded.json.JSONObject;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ResponseBody;

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
    
    @Autowired
    private IDomicilioServicio interDomicilio;
    
    @Autowired
    private IEnlaceServicio interEnlace;
    
    @Autowired
    private IExperienciaLaboralServicio interExperienciaLaboral;
    
    @Autowired
    private IPersonaServicio interPersona;
    
    @Autowired
    private IEducacionServicio interEducacion;
    
    @Autowired
    private IProyectoServicio interProyecto;
    
    @Autowired
    private ITecnologiaServicio interTecnologia;
    
    @Autowired
    private FirebaseAuth firebaseAuth;
    
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
    
    //Auth
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
    
    // Data management
    @GetMapping("/public/info")
    public DatosDTO getPortfolioInfo(){
        DatosDTO datos = new DatosDTO();
        
        Persona persona = interPersona.getPersona();
        Domicilio domicilio = interDomicilio.getDomicilio();
        List<Educacion> educacion = interEducacion.getEducacion(); //TODO add DTO and enlaces to them
        List<Experiencia_Laboral> experienciaLaboral = interExperienciaLaboral.getExperienciasLaborales();
        List<Proyecto> proyectos = interProyecto.getProyectos();
        List<Tecnologia> tecnologias = interTecnologia.getTecnologias();
        
        datos.setDomicilio(domicilio);
        datos.setEducacion(educacion);
        datos.setExperienciaLaboral(experienciaLaboral);
        datos.setPersona(persona);
        datos.setProyectos(proyectos);
        datos.setTecnologias(tecnologias);
        
        return datos;
    }
    
    @PostMapping("/private/updateProfile")
    public boolean updateProfile(@RequestBody DatosDTO datos){
        
        Persona persona = datos.getPersona();
        updatePersona(persona);
        System.out.println("Saved persona Successfully");
        
        Domicilio domicilio = datos.getDomicilio();
        updateDomicilio(domicilio);
        System.out.println("Saved domicilio successfully");
        
        List<Educacion> educacion = datos.getEducacion();
        updateEducacion(educacion);
        System.out.println("Saved educacion successfully");
        
        List<Experiencia_Laboral> experienciaLaboral = datos.getExperienciaLaboral();
        updateExperiencia(experienciaLaboral);
        System.out.println("Saved experienciaLaboral successfully");
        
        
        List<Proyecto> proyectos = datos.getProyectos();
        updateProyectos(proyectos);
        System.out.println("Saved proyectos successfully");
        
        
        List<Tecnologia> tecnologias = datos.getTecnologias();
        updateTecnologias(tecnologias);
        System.out.println("Saved tecnologias successfully");
        
        return true;
        
        
    }
    
    private void updatePersona(Persona persona){
        Long personaId = interPersona.getPersona().getId_persona();
        persona.setId_persona(personaId);
        interPersona.savePersona(persona);
    }
    
    private void updateDomicilio(Domicilio domicilio){
        Long domicilioId = interDomicilio.getDomicilio().getId_domicilio();
        domicilio.setId_domicilio(domicilioId);
        interDomicilio.saveDomicilio(domicilio);
    }
    
    private void updateEducacion(List<Educacion> educacion){
        List<Educacion> original = interEducacion.getEducacion();
        
        for (int i = 0; i < educacion.size(); i++) {
            if(!original.contains(educacion.get(i))){
                interEducacion.saveEducacion(educacion.get(i));
                
            }
        }
        for (int i = 0; i < original.size(); i++ ){
            if (!educacion.contains(original.get(i))){
                interEducacion.DeleteEducacion(original.get(i).getId_education());
            }
        }
    }
    
    private void updateExperiencia(List<Experiencia_Laboral> experiencia){
        List<Experiencia_Laboral> original = interExperienciaLaboral.getExperienciasLaborales();
        
        for (int i = 0; i < experiencia.size(); i++) {
            if (!original.contains(experiencia.get(i))){
                interExperienciaLaboral.saveExperienciaLaboral(experiencia.get(i));

            }
        }
        for (int i = 0; i < original.size(); i++ ){
            if (!experiencia.contains(original.get(i))){
                interExperienciaLaboral.deleteExperienciaLaboral(original.get(i).getId_experiencia_laboral());
            }
        }
    }
    
    private void updateProyectos(List<Proyecto> proyectos){
        List<Proyecto> original = interProyecto.getProyectos();
        
        for (int i = 0; i < proyectos.size(); i++) {
            if (!original.contains(proyectos.get(i))){
                interProyecto.saveProyecto(proyectos.get(i));

            }
        }
        for (int i = 0; i < original.size(); i++ ){
            if (!proyectos.contains(original.get(i))){
                interProyecto.deleteProyecto(original.get(i).getId_proyecto());
            }
        }
    }
    
    private void updateTecnologias(List<Tecnologia> tecnologias){
        List<Tecnologia> original = interTecnologia.getTecnologias();
        
        for (int i = 0; i < original.size(); i++){
            
            System.out.println("original: "+original.get(i).toString());
        }
        
        for (int i = 0; i < tecnologias.size(); i++) {
            if (!original.contains(tecnologias.get(i))){
                interTecnologia.saveTecnologia(tecnologias.get(i));
            }
        }
        for (int i = 0; i < original.size(); i++ ){
            if (!tecnologias.contains(original.get(i))){
                interTecnologia.deleteTecnologia(original.get(i).getId_tecnologia());
            }
        }
    }
    
    //Firebase
    
    @GetMapping("/protected/firebaseToken")
    @ResponseBody
    public JSONObject getToken() throws FirebaseAuthException, InterruptedException, ExecutionException{
        
        String uid = "MehLabs";
        
        String customToken = FirebaseAuth.getInstance().createCustomToken(uid);
        System.out.println(customToken);
        
        JSONObject token = (JSONObject) new JSONObject().appendField("token", customToken);
        System.out.println(token);
        return token;
    }
    
}
