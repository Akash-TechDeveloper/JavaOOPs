package com.javaApp.App.Dto;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Builder

public class AuthRequest {
    private String email;
    private String password;
}
