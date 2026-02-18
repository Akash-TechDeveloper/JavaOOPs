package com.javaApp.App.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Students")
@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String password;
    private Long universityId;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
}
