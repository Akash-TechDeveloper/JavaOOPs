package com.javaApp.App.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponse {
    private Long id;
    private String username;
    private String email;
}
