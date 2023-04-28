package com.projects.site.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float pret;
    private boolean platita;
}
