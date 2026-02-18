package com.javaApp.App.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class StudentRequest {

    @NotBlank
    private String username;
    @NotBlank
    @Size(min = 4)
    private String password;
    @NotBlank
    @Email
    private String email;

    private Long universityId;
}
