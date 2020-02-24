package com.holdings.taskscheduler.controllers;

import com.holdings.taskscheduler.config.security.JwtUtils;
import com.holdings.taskscheduler.model.Role;
import com.holdings.taskscheduler.model.User;
import com.holdings.taskscheduler.model.enumeration.RoleEnum;
import com.holdings.taskscheduler.repository.RoleRepository;
import com.holdings.taskscheduler.repository.UserRepository;
import com.holdings.taskscheduler.service.AuthService;
import com.holdings.taskscheduler.service.dto.LoginDTO;
import com.holdings.taskscheduler.service.dto.UserDTO;
import com.holdings.taskscheduler.service.dto.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AuthService authService;

//    private Logger logger = (Logger) LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginRequest) {

        System.out.println("Let's Sign in {}"+ loginRequest);

        return authService.login(loginRequest);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO signUpRequest) {

        System.out.println("Let's Sign up {}"+ signUpRequest);
        if (userRepository.existsByPhone(signUpRequest.getPhone())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Phone Number is already Registered!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        User user= new User();

        user.setName(signUpRequest.getName());
        user.setPhone(signUpRequest.getPhone());
        user.setEmail(signUpRequest.getEmail());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        System.out.println("After Encoding {}"+ user);



        if (strRoles == null) {
            Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(RoleEnum.ROLE_SUPER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        System.out.println("Just before save {}"+ user);

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping("/get/user")
    public ResponseEntity<List<User>> getUser() throws URISyntaxException {
        return ResponseEntity.created(new URI("/api/auth/get/user"))
                .body(userRepository.findAll());
    }
}
