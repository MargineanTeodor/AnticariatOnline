package com.projects.site.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarteDTO {
    private Long id;
    private String name;
    private int nrPag;
    private int pret;
    private int stare;
    private String autor;
}
