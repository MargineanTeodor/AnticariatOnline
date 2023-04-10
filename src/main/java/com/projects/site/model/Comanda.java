package com.projects.site.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float pret;
    private boolean platita;
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "id")
    private List<Carte> carteList;
}
