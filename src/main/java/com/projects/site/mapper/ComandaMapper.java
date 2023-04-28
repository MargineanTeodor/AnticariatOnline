package com.projects.site.mapper;

import com.projects.site.DTO.ComandaDTO;
import com.projects.site.model.Comanda;
import org.springframework.stereotype.Component;

@Component
public class ComandaMapper {
    public static ComandaDTO mapModelToDto(Comanda comanda)
    {
        ComandaDTO x = new ComandaDTO();
        x.setId(comanda.getId());
        x.setPlatita(comanda.isPlatita());
        x.setPret(comanda.getPret());
        return x;
    }
    public static Comanda mapDtoToModel(ComandaDTO comanda)
    {
        Comanda x = new Comanda();
        x.setId(comanda.getId());
        x.setPlatita(Boolean.FALSE);
        x.setPret(comanda.getPret());
        return x;
    }
}
