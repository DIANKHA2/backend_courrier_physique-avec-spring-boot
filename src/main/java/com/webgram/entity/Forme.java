package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Forme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long forme_id;
    @Enumerated(EnumType.STRING)
    private FormeEnum libelle;

}
