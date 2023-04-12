package com.projects.site.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComandaDTO {
    private Long id;
    private float pret;
    private boolean platita;
}
