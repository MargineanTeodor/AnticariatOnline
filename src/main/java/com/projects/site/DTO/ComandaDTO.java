package com.projects.site.DTO;
import com.projects.site.model.Carte;
import com.projects.site.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComandaDTO {
    private Long id;
    private float pret;
    private boolean platita;
    private User user;
}
