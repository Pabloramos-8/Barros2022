package com.example.barros.rest;

import com.example.barros.service.EventoService;
import com.example.barros.service.UsuarioService;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

public class UsuarioREST {
/*
    @Autowired
    private UsuarioService userRepository;
    @PostMapping(path="/signup", consumes = {"multipart/form-data"})
    public ResponseEntity<?> registerUser(@RequestPart("image") @Nullable
                                          MultipartFile multipartFile , @Valid @RequestPart("user") SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(Response.errorResponse(HttpStatus.CONFLICT.value(),"Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(Response.errorResponse(HttpStatus.CONFLICT.value(),"Error: Email is already in use!"));
        }
        UUID uuid = UUID.randomUUID();
        String fileName = StringUtils.cleanPath( uuid+"_" +
                multipartFile.getOriginalFilename());
// Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        user.setPhoto("users/"+fileName);
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole =
                                roleRepository.findByName(ERole.ROLE_ADMIN)
                                        .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
    break;
    default:
    Role userRole =
            roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                            roles.add(userRole);
}
});
        }
        user.setRoles(roles);
        User savedUser= userRepository.save(user);
        String uploadDir = "users/"+uuid+"_";
        fileStorageService.storeFile(uploadDir,multipartFile);
        return new ResponseEntity<>("User registered successfully!",
        HttpStatus.OK);
    }*/
}
