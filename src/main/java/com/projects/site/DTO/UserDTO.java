package com.projects.site.DTO;

import com.projects.site.model.Carte;
import com.projects.site.model.Comanda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String name;
    private String passw;
    private Boolean admin;
    private List<Carte> carteList;
    private List<Comanda> comandaList;
}
