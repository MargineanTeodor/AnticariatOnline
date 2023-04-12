package com.projects.site.mapper;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.model.Carte;
import org.springframework.stereotype.Component;

@Component
public class CarteMapper {
    public static CarteDTO mapModelToDto(Carte carte)
    {
        CarteDTO x= new CarteDTO();
        x.setAutor(carte.getAutor());
        x.setName(carte.getName());
        x.setId(carte.getId());
        x.setPret(carte.getPret());
        x.setStare(carte.getStare());
        x.setNrPag(carte.getNrPag());
        x.setUser(carte.getUser());
        return x;
    }
    public static Carte mapDtoToModel(CarteDTO carte)
    {
        Carte x= new Carte();
        x.setAutor(carte.getAutor());
        x.setName(carte.getName());
        x.setId(carte.getId());
        x.setPret(carte.getPret());
        x.setStare(carte.getStare());
        x.setNrPag(carte.getNrPag());
        x.setUser(carte.getUser());
        return x;
    }

}
