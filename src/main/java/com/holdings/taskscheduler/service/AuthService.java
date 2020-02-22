package com.holdings.taskscheduler.service;

import com.holdings.taskscheduler.config.security.JwtUtils;
import com.holdings.taskscheduler.service.dto.LoginDTO;
import com.holdings.taskscheduler.service.dto.response.JwtResponse;
import com.holdings.taskscheduler.service.dto.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    public ResponseEntity<?> login(LoginDTO loginRequest){
        try{
            Authentication authentication  = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getPhone(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            System.out.println("Got here jwt"+ jwt);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles));
        } catch (Exception ex){
            System.out.println("Encountered Exception"+ ex.getLocalizedMessage());
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse(ex.getLocalizedMessage()));
        }
    }
}
