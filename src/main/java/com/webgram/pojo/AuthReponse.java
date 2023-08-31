package com.webgram.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthReponse {
    private String token;//sa retourne le tocken
}
