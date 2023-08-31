package com.webgram.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {  // nous demande juste l'@mail et mon de passe
    private String email;
    private String password;
}
