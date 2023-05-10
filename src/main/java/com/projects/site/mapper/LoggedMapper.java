package com.projects.site.mapper;

import com.projects.site.DTO.CarteDTO;
import com.projects.site.DTO.LoggedDTO;
import com.projects.site.model.Carte;
import com.projects.site.model.Logged;
import org.springframework.stereotype.Component;

@Component
public class LoggedMapper {
    public static LoggedDTO mapModelToDto(Logged tabel)
    {
        LoggedDTO x = new LoggedDTO();
        x.setAction(tabel.getAction());
        x.setUserID(tabel.getUserID());
        x.setId(tabel.getId());
        return x;
    }
    public static Logged mapDtoToModel(LoggedDTO tabel)
    {
        Logged x = new Logged();
        x.setAction(tabel.getAction());
        x.setUserID(tabel.getUserID());
        x.setId(tabel.getId());
        return x;
    }
}
