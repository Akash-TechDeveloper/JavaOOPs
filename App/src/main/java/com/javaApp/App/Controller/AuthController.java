package com.javaApp.App.Controller;


import com.javaApp.App.Dto.AuthRequest;
import com.javaApp.App.Security.CustomUserDetailsService;
import com.javaApp.App.Security.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
        public ResponseEntity<?> login (@RequestBody AuthRequest authRequest){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(),
                        authRequest.getPassword()
                )
        );
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getEmail());

            String role = Objects.requireNonNull(userDetails.getAuthorities().iterator().next().getAuthority())
                    .replace("ROLE_", "");;

            String token = jwtUtil.generate_Key(userDetails.getUsername(),role);
            return ResponseEntity.ok(Map.of("Token",token));
        }


}
